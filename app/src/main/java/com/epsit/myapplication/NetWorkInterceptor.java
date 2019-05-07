package com.epsit.myapplication;

import android.util.Log;

import com.google.gson.Gson;

import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * 网络请求的拦截器类，主要是在调试代码的时候可以输出拦截到的请求的参数等信息
 * Created by Nicholas on 2016/11/6.
 */

public class NetWorkInterceptor implements Interceptor {
    public static final String TAG = "NetWorkInterceptor";

    public enum Level {
        NONE,
        HEADERS,
        BODY
    }

    private volatile Level level = Level.NONE;
    Gson mGson = new Gson();
    @Override
    public Response intercept(Chain chain) throws IOException {
        Level level = this.level;

        Request request = chain.request();
        String method = request.method();
        if (method.equals("POST")) {
            RequestBody requestBody = request.body();
            HashMap<String, Object> rootMap = new HashMap<>();
            /**
             * 2018-11-29 注释说明：
             * 原本的想法是通过拦截器来添加请求参数的machineCode的，但是获取这个机器码可能是RobotActionProvider.getInstance().getRobotID()得到的一串唯一的字符串，
             * 也可能是mac地址，具体看 MacUtil.java的getRobotId(Context) 方法的实现，而RobotActionProvider这个类需要导入相应机器人的jar，而且uu机器人没有这么一个类的
             * 所以这个机器码不是通用的，导致在myrobotlibrary工程里的网络请求获取不到正确的机器码，而出现机器人码不一致的错误
             * 所以直接将拦截器去掉了，机器码直接加在请求类里，机器码的获取通过 MacUtil.java 来操作
             *
             */
            //rootMap.put("machineCode", AppUtil.getLocalMacAddressFromIp(RobotBaseApplication.getInstance()).trim());
            if (requestBody instanceof FormBody) {
                for (int i = 0; i < ((FormBody) requestBody).size(); i++) {
                    rootMap.put(((FormBody) requestBody).encodedName(i), ((FormBody) requestBody).encodedValue(i));
                }
            } else {
                //buffer流
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                String oldParamsJson = buffer.readUtf8();
                rootMap = mGson.fromJson(oldParamsJson, HashMap.class);  //原始参数
                //rootMap.put("machineCode", AppUtil.getLocalMacAddressFromIp(RobotBaseApplication.getInstance()).trim());  //重新组装
            }
            String newJsonParams = mGson.toJson(rootMap);  //装换成json字符串
            Log.e(TAG,"req_json= "+newJsonParams);
            request = request.newBuilder().post(RequestBody.create(MediaType.parse("application/json"), newJsonParams)).build();
        }else{
            Log.e(TAG,"还是之前的get请求，不动他-->");
        }
        Response response = chain.proceed(request);
        return response;
    }

    private String protocol(Protocol protocol) {
        return null;
    }

    static boolean isPlaintext(Buffer buffer){
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

}

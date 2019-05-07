package com.epsit.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

/**
 * Basse网络请求控制类
 * 如果要打包apk为正式环境的包，需要修改本类的两个地方：
 * 1、//对外发布环境 和 //公司内部测试环境  的变量注释和非注释的代码 修改切换
 * 2、getApiService() 方法也有对应的，也注释不需要的环境的方法，留下需要的方法
 * Created by Nicholas on 2016/10/30.
 */

public class ApiEngine {
    public static String local_video_dir = "/mnt/sdcard/epsit/video/";
    public static String url = BuildConfig.BASE_URL;

    public static String webHomeUrl = "file:///mnt/sdcard/epsit/html/index.html";

    //人脸识别消息（消息发给子线程）
    public final static int MSG_GREETING_FACETRACKING = -100;
    //打招呼有识别到人脸的msgId，消息会回到主线程
    public final static int MSG_GREETING_HASFACE = -101;
    //打招呼没有识别到人脸的msgId，消息会回到主线程
    public final static int MSG_GREETING_NOFACE = -102;

    public final static int MSG_RECTFACE_TRACKING = -110;
    public final static int MSG_RECTFACE_GETFACEID = -111;
    public final static int MSG_RECTFACE_NOFACE = -112;

    public final static int REQUEST_TAKEPHOTO = 1000;
    public final static int REQUEST_SIGN = 10;

    private volatile static ApiEngine apiEngine;
    private Retrofit retrofit;
    OkHttpClient client;
    Gson gson;
    //人脸相识度的对比分数要超过这个值
    public static final float facematchscore = 0.55f;

    public static final String setting_fname = "setting";

    static {
        RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler() {
                @Override
                public void handleError(Throwable e) {
                    try {
                        if(e!=null) {
                            e.printStackTrace();
                        }
                    }catch(Exception exception){

                    }
                }



        });
    }
    private ApiEngine() {

        //缓存
        int size = 1024 * 1024 * 100;
        File cacheFile = new File("/mnt/sdcard/epsit/", "OkHttpCache");
        Cache cache = new Cache(cacheFile, size);
        if(!cacheFile.exists()){
            cacheFile.mkdirs();
        }
        client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false) //超时不自动重复请求
                .connectTimeout(25, TimeUnit.SECONDS) //网络连接超时时间
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .addNetworkInterceptor(new NetWorkInterceptor())
            .cache(cache)
            .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //构建Retrofit对象
        //然后将刚才设置好的okHttp对象,通过retrofit.client()方法 设置到retrofit中去
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }
    public static ApiEngine getInstance() {
        if (apiEngine == null) {
            synchronized (ApiEngine.class) {
                if (apiEngine == null) {
                    apiEngine = new ApiEngine();
                }
            }
        }
        return apiEngine;
    }

}

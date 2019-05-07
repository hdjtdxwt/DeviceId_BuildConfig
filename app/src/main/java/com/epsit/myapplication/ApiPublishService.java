package com.epsit.myapplication;



import com.epsit.myapplication.requestbean.CheckUpgradeRequest;
import com.epsit.myapplication.requestbean.CheckUpgradeResponse;
import com.epsit.myapplication.requestbean.LocalLibraryRequest;
import com.epsit.myapplication.requestbean.LocalLibraryResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 发布环境  网络请求接口类
 * Created by Nicholas on 2016/10/30.
 * API：http://robot.epsit.cn:7078
 语音：http://robot.epsit.cn:7074

 */

public interface ApiPublishService {

    //获取本地库数据
    @POST("http://trading.epsit.cn/knowledge/local")
    Observable<LocalLibraryResponse> getLocalLibrary(@Body LocalLibraryRequest request);

    //apk更新请求接口
    @POST("api/robot/downloadNewApk")
    Observable<CheckUpgradeResponse>checkUpgrade(@Body CheckUpgradeRequest request);

}


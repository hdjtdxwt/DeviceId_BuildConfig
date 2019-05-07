package com.epsit.myapplication;

import com.epsit.myapplication.requestbean.CheckUpgradeRequest;
import com.epsit.myapplication.requestbean.CheckUpgradeResponse;
import com.epsit.myapplication.requestbean.LocalLibraryRequest;
import com.epsit.myapplication.requestbean.LocalLibraryResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2019/5/7/007.
 */

public interface ApiTestService {
    @POST("api/robot/downloadNewApk")
    Observable<CheckUpgradeResponse> checkUpgrade(@Body CheckUpgradeRequest request);

    //获取本地库数据
    @POST("http://trading.epsit.cn/knowledge/local")
    Observable<LocalLibraryResponse> getLocalLibrary(@Body LocalLibraryRequest request);
}

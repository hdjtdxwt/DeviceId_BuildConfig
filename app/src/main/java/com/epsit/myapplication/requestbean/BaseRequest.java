package com.epsit.myapplication.requestbean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseRequest {
    //每个请求（99%的请求）都需要带的两个参数 token和用户的id，放在了父类里头
    protected String token;
    protected String robotId;

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        //考虑到机器码里的特殊字符会被转义，特意加上这么一个toJson的方法 2018-11-27
        Gson gs = new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();
        return gs.toJson(this);
    }
}

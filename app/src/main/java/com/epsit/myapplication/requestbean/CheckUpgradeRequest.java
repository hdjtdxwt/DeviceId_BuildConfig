package com.epsit.myapplication.requestbean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * apk请求升级的类
 * Created by Administrator on 2018/10/18/018.
 */

public class CheckUpgradeRequest  extends BaseResponse {

    /** *
        token和robotId没有了，换成了机器码，以为确定机器人的一个编号，事先 机器码和机器人登录账号会绑定的（实际上是和机构绑定）
     * type : 1          0：艾娃     1：UU   2：小曼
     * currentVersion  : 1.0  这个currentVersion自己给的是code值，是一个整数，build.gradle里的versionCode的值，不是versionName
     * requestVersion :  请求下载的版本号，如果为空则返回最新版本，否则返回指定版本
     */
    private String type; //机器人类型
    private String currentVersion; //apk当前版本号
    private String currentHtmlVersion; //html当前版本号
    private String machineCode; //机器人码

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getCurrentHtmlVersion() {
        return currentHtmlVersion;
    }

    public void setCurrentHtmlVersion(String currentHtmlVersion) {
        this.currentHtmlVersion = currentHtmlVersion;
    }
}

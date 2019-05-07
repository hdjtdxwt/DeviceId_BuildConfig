package com.epsit.myapplication.requestbean;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2018/10/18/018.
 */

public class CheckUpgradeResponse  {
    /**
     * code : 200
     * message : 成功
     * data : {"id":"4bd6b86e75d343279f9e2157a55d8c41","versionCode":2,"version":"2.0","apkPrefix":"http://192.168.1.9:8080/app","apkUrl":"/app/uu/2.0/1.0-2.0.batch","appType":1,"forces":"1","htmlVersion":"1.0","appliedRange":"0","officeIds":""}
     * pageNum : 1
     * pageSize : 10
     * total : 0
     * pages : 0
     */

    private String code;
    private String message;
    private DataBean data;
    private int pageNum;
    private int pageSize;
    private int total;
    private int pages;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }



    public static class DataBean {
        /**
         * versionCode : 10
         * version : 10.0
         * apkPrefix : http://download-test.epsit.cn:6066/img
         * apkUrl : /userfiles/1/app/robotApk/2018/10/xm1_5-8088-c10v1_9-10-17-tiantan.apk
         * apkType : 2
         * htmlUrl : /userfiles/1/html/robotHtml/2018/10/v1_0_0.zip
         * htmlPrefix : http://download-test.epsit.cn:6066/img
         * forces : 1
         * htmlVersion : 1
         * officeIds : 9a76986662914b2db00ac02268a1b4c5
         * appliedRange : 1
         * remarks : xm1.5-8088-c10v1.9-10-17-tiantan.apk  专门给天坛医院，其他医院不要给（还未测试下，没机器人测试）
         更新内容：
         宋超说天坛医院的有导航功能，没有闲时播视频（代码需要注释），同时又各种闲聊（需要有瑞曼的回答）
         * needUpdated : 1
         */

        private int versionCode;
        private String version;
        private String apkPrefix;
        private String apkUrl;
        private int apkType;
        private String htmlUrl;
        private String htmlPrefix;
        //强制升级（0：否 1：是）
        private String forces;
        private String htmlVersion;
        private int htmlVersionCode;
        private String officeIds;
        private String appliedRange;
        //更新备注
        private String remarks;
        //是否需要更新（0：否 1：是）
        private String needUpdated;

        //html是否强制升级（0：否 1：是）
        private String htmlForces;
        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getApkPrefix() {
            return apkPrefix;
        }

        public void setApkPrefix(String apkPrefix) {
            this.apkPrefix = apkPrefix;
        }

        public String getApkUrl() {
            return apkUrl;
        }

        public void setApkUrl(String apkUrl) {
            this.apkUrl = apkUrl;
        }

        public int getApkType() {
            return apkType;
        }

        public void setApkType(int apkType) {
            this.apkType = apkType;
        }

        public String getHtmlUrl() {
            return htmlUrl;
        }

        public void setHtmlUrl(String htmlUrl) {
            this.htmlUrl = htmlUrl;
        }

        public String getHtmlPrefix() {
            return htmlPrefix;
        }

        public void setHtmlPrefix(String htmlPrefix) {
            this.htmlPrefix = htmlPrefix;
        }

        public String getForces() {
            return forces;
        }

        public void setForces(String forces) {
            this.forces = forces;
        }

        public String getHtmlVersion() {
            return htmlVersion;
        }

        public void setHtmlVersion(String htmlVersion) {
            this.htmlVersion = htmlVersion;
        }

        public String getOfficeIds() {
            return officeIds;
        }

        public void setOfficeIds(String officeIds) {
            this.officeIds = officeIds;
        }

        public String getAppliedRange() {
            return appliedRange;
        }

        public void setAppliedRange(String appliedRange) {
            this.appliedRange = appliedRange;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getNeedUpdated() {
            return needUpdated;
        }

        public void setNeedUpdated(String needUpdated) {
            this.needUpdated = needUpdated;
        }

        public String getHtmlForces() {
            return htmlForces;
        }

        public void setHtmlForces(String htmlForces) {
            this.htmlForces = htmlForces;
        }

    }
}

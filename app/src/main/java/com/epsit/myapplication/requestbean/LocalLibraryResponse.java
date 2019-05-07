package com.epsit.myapplication.requestbean;

import com.epsit.myapplication.dbentity.LocalLibraryData;
import com.google.gson.Gson;

import java.util.List;

/**
 * 本地库响应
 */

public class LocalLibraryResponse extends BaseResponse{
    private String localID;
    private String code;
    private String message;
    private int pageNum;
    private int pageSize;
    private int total;
    private int pages;
    private List<LocalLibraryData> data;

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

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

    public List<LocalLibraryData> getData() {
        return data;
    }

    public void setData(List<LocalLibraryData> data) {
        this.data = data;
    }

}

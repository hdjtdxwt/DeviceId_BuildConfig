package com.epsit.myapplication.dbentity;

import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

/**
 * 原本这个类是写在LocalLibraryResponse里作为内部类的，但考虑到需要将请求的数据保存到数据库中，所以单独写出来了（非要写成内部类也ok）
 * 本地库实体
 */

public class LocalLibraryData extends DataSupport {
    private String localID;
    private String belongToPage; //当前页面
    private String answer;
    private String keyword;
    private String type;


    private String pageJump; //跳转页面
    private String instructions;
    private String locationX;
    private String locationY;
    private String angle;
    private String password;

    public void update(LocalLibraryData da){
        this.localID=da.getLocalID();
        this.belongToPage=da.getBelongToPage();
        this.type=da.getType();
        this.answer=da.getAnswer();
        this.pageJump=da.getPageJump();
        this.instructions=da.getInstructions();

        this.locationX = da.getLocationX();
        this.locationY = da.getLocationY();
        this.angle = da.getAngle();
        this.password = da.getPassword();
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getBelongToPage() {
        return belongToPage;
    }

    public void setBelongToPage(String belongToPage) {
        this.belongToPage = belongToPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPageJump() {
        return pageJump;
    }

    public void setPageJump(String pageJump) {
        this.pageJump = pageJump;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

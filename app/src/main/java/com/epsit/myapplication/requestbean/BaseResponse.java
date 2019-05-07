package com.epsit.myapplication.requestbean;

import com.alibaba.fastjson.JSON;

public class BaseResponse {

    //toString() 转换成json，写在父类不用每个子类都写一遍，同时用fastjson的处理不需要new Gson()，这样不会每一个类都创建一个Gson对象
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

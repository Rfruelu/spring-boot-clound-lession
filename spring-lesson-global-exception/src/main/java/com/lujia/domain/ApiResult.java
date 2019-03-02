package com.lujia.domain;

import lombok.Data;

/**
 * 全局异常返回结果
 * @author :lujia
 * @date :2018/11/27  10:06
 */
@Data
public class ApiResult {

    private ApiResult(){

    }

    public static ApiResult newInstance(){
        return new ApiResult();
    }

    /**
     * 消息提示
     */
    private String message;

    private boolean flag=true;

    private Object result;

    private int rows;

    private String jumpUrl;

    private long time;

}

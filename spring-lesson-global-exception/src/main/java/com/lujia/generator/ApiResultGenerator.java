package com.lujia.generator;

import com.lujia.domain.ApiResult;

import java.util.List;

/**
 * @author :lujia
 * @date :2018/11/27  11:08
 */
public class ApiResultGenerator {


    public static ApiResult createResult(boolean flag,String message,Object result ,String jumpUrl,int rows,Throwable throwable){
        ApiResult apiResult=ApiResult.newInstance();
        apiResult.setFlag(flag);
        apiResult.setMessage(message==""?"执行成功":message);
        apiResult.setResult(result);
        apiResult.setRows(rows);
        apiResult.setJumpUrl(jumpUrl);
        return apiResult;
    }


    public static ApiResult successResult(Object result){
        int rows=1;
        if (result instanceof List){
            rows=((List) result).size();
        }
        return createResult(true,"",result,"",rows,null);
    }

    public static ApiResult failedResult(String message,Throwable throwable){
        return createResult(false,message,null,"",0,throwable);
    }

}

package com.lujia.advice;

import com.lujia.domain.ApiResult;
import com.lujia.generator.ApiResultGenerator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :lujia
 * @date :2018/11/27  9:52
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class GlobalExceptionAdvice {


    /*@ExceptionHandler
    @ResponseStatus
    public Map<String,Object> exceptionHandler(Exception e){

        Map<String,Object> map=new HashMap<>(3);

        map.put("message",e.getMessage());
        map.put("cause",e.getCause());
        return map;
    }*/
    @ExceptionHandler
    @ResponseStatus
    public ApiResult exceptionHandler(Exception e){


        return ApiResultGenerator.failedResult(e.getMessage(),e);
    }
}

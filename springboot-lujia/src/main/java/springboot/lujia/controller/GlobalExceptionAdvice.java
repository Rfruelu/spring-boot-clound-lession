package springboot.lujia.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :lujia
 * @date :2018/11/14  14:44
 */
@ControllerAdvice
public class GlobalExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public ModelAndView errorPage(HttpServletRequest request,Exception e) {

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map> jsonExceptionHandler(HttpServletRequest request, NullPointerException e){

        Map<String,Object> map=new HashMap(2);
        map.put("message",e.getMessage());
        map.put("url",request.getRequestURL());
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json"));
        return new ResponseEntity<Map>(map,httpHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.lujia.controller;

import com.lujia.entity.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @author :lujia
 * @date :2018/11/26  10:38
 */
@RestController
public class ValidatorDemoController {


    @Autowired
    private MessageSource messageSource;
    @RequestMapping("/validator")
    public String validator(@Valid DemoEntity demoEntity, BindingResult result){

        if (result.hasErrors()){
            StringBuilder stringBuilder=new StringBuilder();

            List<FieldError> fieldErrors = result.getFieldErrors();

            Locale locale = LocaleContextHolder.getLocale();


            fieldErrors.forEach(fieldError -> {
                String message = messageSource.getMessage(fieldError, locale);
                stringBuilder.append(fieldError.getField()).append(":").append(message).append("\n");
            });
            return stringBuilder.toString();
        }

        return "验证通过"+ demoEntity;
    }
}

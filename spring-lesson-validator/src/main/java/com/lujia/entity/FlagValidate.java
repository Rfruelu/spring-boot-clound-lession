package com.lujia.entity;

import com.lujia.annotation.FlagValidator;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义验证注解处理类
 * @author :lujia
 * @date :2018/11/26  11:26
 */
public class FlagValidate implements ConstraintValidator<FlagValidator,Object>{

    private String  values;

    /**
     * 初始化验证消息
     * @param constraintAnnotation
     */
    @Override
    public void initialize(FlagValidator constraintAnnotation) {
       values= constraintAnnotation.values();
    }

    /**
     * 验证方法
     * @param o
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag=false;
        if (!StringUtils.isEmpty(values)){
            String[] split = values.split(",");
            for (String s : split) {
                if (s.equals((String)o)){
                    flag= true;
                    break;
                }
            }
        }
        return flag;
    }
}

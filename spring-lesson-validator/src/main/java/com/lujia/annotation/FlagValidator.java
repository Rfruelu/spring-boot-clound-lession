package com.lujia.annotation;

import com.lujia.entity.FlagValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义验证注解
 * @author :lujia
 * @date :2018/11/26  11:15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = FlagValidate.class)
public @interface FlagValidator {

    String values();

    String message() default "flag不存在";

    /**
     * 默认属性，必须加上
     * @return
     */
    Class<?>[] groups() default {};
    /**
     * 默认属性，必须加上
     * @return
     */
    Class<? extends Payload>[] payload() default {};

}

package com.lujia.entity;

import com.lujia.annotation.FlagValidator;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author :lujia
 * @date :2018/11/26  10:27
 */
@Data
public class DemoEntity implements Serializable{
    private static final long serialVersionUID = 4720691860416090995L;


    /**
     * @NotNull 不能为null，
     * @Length(min = 2,max = 10)  长度最小2，最大10
     */
    @NotNull
    @Length(min = 2,max = 10)
    private String name;

    /**
     * @Min(20) 必须大于等于20
     */
    @Min(20)
    private int age;

    /**
     * @Email 邮箱格式校验
     */
    @NotBlank
    @Email
    private String email;

    @FlagValidator(values = "1,2,3")
    private String flag;

}

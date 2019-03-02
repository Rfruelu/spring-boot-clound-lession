package com.lujia.demain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :lujia
 * @date :2018/11/27  15:45
 */
@Data
public class User implements Serializable {


    private static final long serialVersionUID = -2118099759790869799L;

    private String name;

    private Integer age;


}

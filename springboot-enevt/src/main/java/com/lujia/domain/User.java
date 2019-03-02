package com.lujia.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :lujia
 * @date :2018/12/13  15:21
 */
@Data
public class User implements Serializable{
    private static final long serialVersionUID = -8584120439453416088L;

    private String name;


    private String password;


}

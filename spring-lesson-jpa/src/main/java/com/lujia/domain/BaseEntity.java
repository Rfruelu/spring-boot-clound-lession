package com.lujia.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页组件
 * @author :lujia
 * @date :2018/11/23  15:08
 */
@Data
public class BaseEntity implements Serializable {


    /**
     *分页页码，默认1
     */
    protected int page=1;
    /**
     * 分页大小，默认20
     */
    protected int size=20;


    private String sord;

    private String storIdx="id";

}

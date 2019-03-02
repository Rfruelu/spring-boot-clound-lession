package com.lujia.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :lujia
 * @date :2018/11/20  15:47
 */
@Data
public class LoggerEntity implements Serializable{
    private static final long serialVersionUID = 3152165630695825340L;

    private String clientIp;

    private String url;
    private int status;

    private String type;

    private String method;

    private String paramData;

    private String requestId;
    private Date time;
    private Date returnTime;

    private Object returnData;


}

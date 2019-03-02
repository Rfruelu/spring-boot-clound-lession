package com.lujia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author :lujia
 * @date :2018/11/16  10:22
 */
@Entity
@Table(name = "redis_role")
public class RedisRole implements Serializable{
    private static final long serialVersionUID = -3722607639305675814L;

    @Id
    @GeneratedValue
    private Long id;

    /**
     * @Column  注解无效
     */
    @Column(name = "mgmtName")
    private String mgmtName;

    private String remark;
    @Column(name = "createDate")
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMgmtName() {
        return mgmtName;
    }

    public void setMgmtName(String mgmtName) {
        this.mgmtName = mgmtName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

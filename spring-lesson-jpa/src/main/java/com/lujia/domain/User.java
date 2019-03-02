package com.lujia.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author :lujia
 * @date :2018/11/20  9:08
 */
@Entity
@Table(name = "csmbp_user")
@Data
public class User extends BaseEntity {
    private static final long serialVersionUID = -8584120439453416088L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String username;
    private String password;
    private String email;



}

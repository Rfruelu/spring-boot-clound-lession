package com.lujia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @NoRepositoryBean 注解如果配置在继承了JpaRepository接口以及其他SpringDataJpa内部的接口的子接口时，
 * 子接口不被作为一个Repository创建代理实现类。
 *
 * @author :lujia
 * @date :2018/11/23  15:05
 */
@NoRepositoryBean
public interface BaseRepository<T, PK extends Serializable> extends JpaRepository<T, PK> {
}

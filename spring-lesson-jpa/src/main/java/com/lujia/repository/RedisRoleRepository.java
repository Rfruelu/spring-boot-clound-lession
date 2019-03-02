package com.lujia.repository;

import com.lujia.domain.RedisRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author :lujia
 * @date :2018/11/16  10:32
 */
public interface RedisRoleRepository extends JpaRepository<RedisRole,Long>,JpaSpecificationExecutor<RedisRole>,Serializable {


}

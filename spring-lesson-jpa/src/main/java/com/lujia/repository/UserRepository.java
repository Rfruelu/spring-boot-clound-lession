package com.lujia.repository;

import com.lujia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * 如果需要事物操作，需要加上@Transactional注解，否则会报下面的异常
 * javax.persistence.TransactionRequiredException: Executing an update/delete query
 * @author :lujia
 * @date :2018/11/20  9:24
 */

@Transactional
public interface UserRepository extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{

    /**
     *  @Query 表示自定义的查询语句，nativeQuery =true表示使用原生sql查询语句，=false就表示使用使用hql查询语句
     * @param email
     * @return
     */

    @Query(value = "select * from csmbp_user where email=?1 ",nativeQuery = true)
    public List<User> findByEmail(String email);

    @Modifying
    @Query(value = "delete from csmbp_user where username=?1 and password=?2" ,nativeQuery = true)
    void deleteByNameAndPassword(String name,String password);
}

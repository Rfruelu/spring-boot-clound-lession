package com.lujia.controller;

import com.lujia.domain.RedisRole;
import com.lujia.repository.RedisRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author :lujia
 * @date :2018/11/16  10:10
 */
@RestController
//@RequestMapping(value = "/redis/role",produces ={ "application/json;charset=UTF-8" })
@RequestMapping(value = "/redis/role")
public class RedisRoleController {

    @Autowired
    private RedisRoleRepository redisRoleRepository;


    @RequestMapping("/getAll")
    public List<RedisRole> getAll() {
        return redisRoleRepository.findAll();

    }

    @RequestMapping("/insert")
    public Object insert(@RequestParam(name = "name") String name, @RequestParam(name = "remark") String remark) {
        RedisRole redisRole = new RedisRole();
        redisRole.setCreateDate(new Date());
        redisRole.setMgmtName(name);
        redisRole.setRemark(remark);
        return redisRoleRepository.save(redisRole);
    }


    @RequestMapping("/delete")
    public Object delete(@RequestParam(name = "id") Long id) {
        try {

            redisRoleRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

}

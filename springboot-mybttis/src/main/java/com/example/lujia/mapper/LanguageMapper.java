package com.example.lujia.mapper;

import com.example.lujia.domain.Language;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by LuTshoes on 2017/7/18 0018.
 * lutshoes@163.com
 */
//此处可以使用@mapper注解代替启动类中的@MapperScan("com.example.lujia.mapper")
@Mapper
public interface LanguageMapper {

    Language findById(@Param("id") Long id);
}

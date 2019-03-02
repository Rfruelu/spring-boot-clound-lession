package com.lujia.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * @author :lujia
 * @date :2018/11/26  15:21
 */
@Configuration
@EnableCaching
@Slf4j
public class RedisConfiguration extends CachingConfigurerSupport{

    /**
     * 使用redisCacheManager作为缓存管理器
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }

    /**
     * 自定义key生成规则
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {

        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder stringBuilder=new StringBuilder();

                //类名
                stringBuilder.append(target.getClass().getName());
                //方法名
                stringBuilder.append(method.getName());
                //参数
                for (Object param : params) {
                    stringBuilder.append(param.toString());
                }
                log.info("调用redis缓存的key是,{}",stringBuilder.toString());
                return stringBuilder.toString();
            }
        };
        //return super.keyGenerator();
    }
}

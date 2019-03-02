package com.lujia;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;
import org.springframework.stereotype.Component;

/**
 * @author :lujia
 * @date :2018/11/16  15:29
 */
@Component
public class MyNamingStrategy extends ImprovedNamingStrategy {


    @Override
    public String propertyToColumnName(String propertyName) {
        return StringHelper.unqualify(propertyName);
    }
}

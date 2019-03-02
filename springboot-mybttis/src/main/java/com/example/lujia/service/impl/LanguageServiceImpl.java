package com.example.lujia.service.impl;

import com.example.lujia.domain.Language;
import com.example.lujia.mapper.LanguageMapper;
import com.example.lujia.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LuTshoes on 2017/7/18 0018.
 * lutshoes@163.com
 */
@Service
public class LanguageServiceImpl implements LanguageService{
    @Autowired
    private LanguageMapper languageMapper;
    @Override
    public Language findById(Long id) {
        return languageMapper.findById(id);
    }
}

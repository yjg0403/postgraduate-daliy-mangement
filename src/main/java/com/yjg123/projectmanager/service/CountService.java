package com.yjg123.projectmanager.service;

import com.yjg123.projectmanager.domain.Count;
import com.yjg123.projectmanager.util.PageBean;

import java.util.Map;

/**
 * @Classname CountService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface CountService {
    PageBean<Count> queryPage(Map<String, Object> paramMap);
    
}

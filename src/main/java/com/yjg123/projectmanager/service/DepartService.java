package com.yjg123.projectmanager.service;

import com.yjg123.projectmanager.domain.Depart;
import com.yjg123.projectmanager.util.PageBean;

import java.util.Map;

/**
 * @Classname DepartService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface DepartService {
    PageBean<Depart> queryPage(Map<String, Object> paramMap);
    
}

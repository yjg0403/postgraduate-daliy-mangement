package com.yjg123.projectmanager.service;

import com.yjg123.projectmanager.domain.StuAchive;
import com.yjg123.projectmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname StuAchiveService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface StuAchiveService {
    PageBean<StuAchive> queryPage(Map<String, Object> paramMap);

    int addStuAchive(StuAchive stuAchive);

    int deleteStuAchive(List<Integer> ids);

    int editStuAchive(StuAchive stuAchive);

    StuAchive findByName(String stuAchiveName);

}

package com.yjg123.projectmanager.service;

import com.yjg123.projectmanager.domain.TeacherAchive;
import com.yjg123.projectmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherAchiveService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface TeacherAchiveService {
    PageBean<TeacherAchive> queryPage(Map<String, Object> paramMap);

    int addTeacherAchive(TeacherAchive teacherAchive);

    int deleteTeacherAchive(List<Integer> ids);

    int editTeacherAchive(TeacherAchive teacherAchive);

    TeacherAchive findByName(String teacherAchiveName);

}

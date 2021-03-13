package com.yjg123.projectmanager.service;



import com.yjg123.projectmanager.domain.Teacher;
import com.yjg123.projectmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface TeacherService {
    PageBean<Teacher> queryPage(Map<String, Object> paramMap);

    int deleteTeacher(List<Integer> ids);

    int addTeacher(Teacher teacher);

    Teacher findById(Integer tid);

    int editTeacher(Teacher teacher);

    Teacher findByTeacher(Teacher teacher);

    int editPswdByTeacher(Teacher teacher);


}

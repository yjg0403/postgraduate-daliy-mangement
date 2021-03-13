package com.yjg123.projectmanager.service;

import com.yjg123.projectmanager.domain.StudentTask;
import com.yjg123.projectmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudentTaskService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface StudentTaskService {
    PageBean<StudentTask> queryPage(Map<String, Object> paramMap);

    int addStudentTask(StudentTask studentTask);

    int deleteStudentTask(List<Integer> ids);

    int editStudentTask(StudentTask studentTask);

    int updateIsRead(StudentTask studentTask);

    StudentTask findByName(String studentTaskName);

}

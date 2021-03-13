package com.yjg123.projectmanager.service;



import com.yjg123.projectmanager.domain.Student;
import com.yjg123.projectmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudentService
 * @Description None
 * @Date 2019/6/27 14:11
 * @Created by WDD
 */
public interface StudentService {
    PageBean<Student> queryPage(Map<String, Object> paramMap);

    int deleteStudent(List<Integer> ids);

    int addStudent(Student student);

    Student findById(Integer sid);

    int editStudent(Student student);

    Student findByStudent(Student student);

    boolean isStudentByTeamId(Integer next);

    int editPswdByStudent(Student student);

    int findByName(String username);
}

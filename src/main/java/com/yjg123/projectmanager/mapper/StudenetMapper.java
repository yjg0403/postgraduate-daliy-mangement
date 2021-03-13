package com.yjg123.projectmanager.mapper;


import com.yjg123.projectmanager.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudenetMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface StudenetMapper {
    List<Student> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int deleteStudent(List<Integer> ids);

    int addStudent(Student student);

    Student findById(Integer sid);

    int editStudent(Student student);

    Student findByStudent(Student student);

    List<Student> isStudentByTeamId(Integer id);

    int editPswdByStudent(Student student);

    int findByName(String name);
}

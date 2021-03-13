package com.yjg123.projectmanager.mapper;



import com.yjg123.projectmanager.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface TeacherMapper {
    List<Teacher> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int deleteTeacher(List<Integer> ids);

    int addTeacher(Teacher teacher);

    Teacher findById(Integer tid);

    int editTeacher(Teacher teacher);

    Teacher findByTeacher(Teacher teacher);

    int editPswdByTeacher(Teacher teacher);
}

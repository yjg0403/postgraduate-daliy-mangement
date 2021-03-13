package com.yjg123.projectmanager.mapper;

import com.yjg123.projectmanager.domain.StudentTask;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudentTaskMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface StudentTaskMapper {
    List<StudentTask> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addStudentTask(StudentTask studentTask);

    int deleteStudentTask(List<Integer> ids);

    void updateState();

    int updateIsRead(StudentTask studentTask);

    int editStudentTask(StudentTask studentTask);

    StudentTask findByName(String studentTaskName);
}

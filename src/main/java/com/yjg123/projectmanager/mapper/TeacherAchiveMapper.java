package com.yjg123.projectmanager.mapper;

import com.yjg123.projectmanager.domain.TeacherAchive;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherAchiveMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface TeacherAchiveMapper {
    List<TeacherAchive> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addTeacherAchive(TeacherAchive teacherAchive);

    int deleteTeacherAchive(List<Integer> ids);

    int editTeacherAchive(TeacherAchive teacherAchive);

    TeacherAchive findByName(String teacherAchiveName);
}

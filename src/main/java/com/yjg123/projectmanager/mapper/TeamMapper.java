package com.yjg123.projectmanager.mapper;

import com.yjg123.projectmanager.domain.Team;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeamMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface TeamMapper {
    List<Team> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addTeam(Team team);

    int deleteTeam(List<Integer> ids);

    int editTeam(Team team);

    Team findByName(String teamName);

    int addTeacher(Map<String, Object> paramMap);

    int addStudent(Map<String, Object> paramMap);

    int deleteStudent(Map<String, Object> paramMap);

    int deleteTeacher(Map<String, Object> paramMap);

    List<String> findTeachersByTeam(String team);

    List<String> findStudentsByTeam(String team);
}

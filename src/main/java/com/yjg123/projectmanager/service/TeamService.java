package com.yjg123.projectmanager.service;

import com.yjg123.projectmanager.domain.Team;
import com.yjg123.projectmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeamService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface TeamService {
    PageBean<Team> queryPage(Map<String, Object> paramMap);

    int addTeam(Team team);

    int deleteTeam(List<Integer> ids);

    int editTeam(Team team);

    Team findByName(String teamName);

    List findTeachersByTeam(String team);

    List findStudentsByTeam(String team);

}

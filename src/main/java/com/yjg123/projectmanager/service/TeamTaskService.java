package com.yjg123.projectmanager.service;

import com.yjg123.projectmanager.domain.StudentTask;
import com.yjg123.projectmanager.domain.TeamTask;
import com.yjg123.projectmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeamTaskService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface TeamTaskService {
    PageBean<TeamTask> queryPage(Map<String, Object> paramMap);

    int addTeamTask(TeamTask teamTask);

    int deleteTeamTask(List<Integer> ids);

    int editTeamTask(TeamTask teamTask);

    TeamTask findByName(String teamTaskName);

    int updateIsRead(TeamTask teamTask);
}

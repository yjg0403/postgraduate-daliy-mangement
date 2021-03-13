package com.yjg123.projectmanager.mapper;

import com.yjg123.projectmanager.domain.StudentTask;
import com.yjg123.projectmanager.domain.TeamTask;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeamTaskMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface TeamTaskMapper {
    List<TeamTask> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addTeamTask(TeamTask teamTask);

    void updateState();

    int updateIsRead(TeamTask teamTask);

    int deleteTeamTask(List<Integer> ids);

    int editTeamTask(TeamTask teamTask);

    TeamTask findByName(String teamTaskName);
}

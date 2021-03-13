package com.yjg123.projectmanager.service.Impl;


import com.yjg123.projectmanager.domain.StudentTask;
import com.yjg123.projectmanager.domain.TeamTask;
import com.yjg123.projectmanager.mapper.TeamTaskMapper;
import com.yjg123.projectmanager.service.TeamTaskService;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeamTaskServiceImpl
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Service
public class TeamTaskServiceImpl implements TeamTaskService {

    @Autowired
    private TeamTaskMapper teamTaskMapper;

    @Override
    public PageBean<TeamTask> queryPage(Map<String, Object> paramMap) {
        PageBean<TeamTask> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<TeamTask> datas = teamTaskMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = teamTaskMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addTeamTask(TeamTask teamTask) {
        return teamTaskMapper.addTeamTask(teamTask);
    }

    @Override
    @Transactional
    public int deleteTeamTask(List<Integer> ids) {
        return teamTaskMapper.deleteTeamTask(ids);
    }

    @Override
    public int editTeamTask(TeamTask teamTask) {
        return teamTaskMapper.editTeamTask(teamTask);
    }

    @Override
    public TeamTask findByName(String teamTaskName) {
        return teamTaskMapper.findByName(teamTaskName);
    }

    @Override
    public int updateIsRead(TeamTask teamTask) {
        return teamTaskMapper.updateIsRead(teamTask);
    }

}

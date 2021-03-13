package com.yjg123.projectmanager.service.Impl;


import com.yjg123.projectmanager.domain.StudentS;
import com.yjg123.projectmanager.domain.Teacher;
import com.yjg123.projectmanager.domain.TeacherS;
import com.yjg123.projectmanager.domain.Team;
import com.yjg123.projectmanager.mapper.TeamMapper;
import com.yjg123.projectmanager.service.TeamService;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Classname TeamServiceImpl
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public PageBean<Team> queryPage(Map<String, Object> paramMap) {
        PageBean<Team> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Team> datas = teamMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = teamMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addTeam(Team team) {
        return teamMapper.addTeam(team);
    }

    @Override
    @Transactional
    public int deleteTeam(List<Integer> ids) {
        return teamMapper.deleteTeam(ids);
    }

    @Override
    public int editTeam(Team team) {
        return teamMapper.editTeam(team);
    }

    @Override
    public Team findByName(String teamName) {
        return teamMapper.findByName(teamName);
    }

    @Override
    public List<TeacherS> findTeachersByTeam(String team) {
        List<String> teachers = teamMapper.findTeachersByTeam(team);
        List<TeacherS> teachersList = new ArrayList<TeacherS>();
        for(String teacher: teachers){
            TeacherS teacherS=new TeacherS();
            teacherS.setNo(teacher);
            teachersList.add(teacherS);
        }
        return teachersList;
    }

    @Override
    public List<StudentS> findStudentsByTeam(String team) {
        List<String> students = teamMapper.findStudentsByTeam(team);
        List<StudentS> studentsList = new ArrayList<StudentS>();
        for(String student: students){
            StudentS studentS=new StudentS();
            studentS.setNo(student);
            studentsList.add(studentS);
        }
        return studentsList;
    }

}

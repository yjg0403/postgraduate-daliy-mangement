package com.yjg123.projectmanager.service.Impl;


import com.yjg123.projectmanager.domain.TeacherAchive;
import com.yjg123.projectmanager.mapper.TeacherAchiveMapper;
import com.yjg123.projectmanager.service.TeacherAchiveService;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherAchiveServiceImpl
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Service
public class TeacherAchiveServiceImpl implements TeacherAchiveService {

    @Autowired
    private TeacherAchiveMapper teacherAchiveMapper;

    @Override
    public PageBean<TeacherAchive> queryPage(Map<String, Object> paramMap) {
        PageBean<TeacherAchive> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<TeacherAchive> datas = teacherAchiveMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = teacherAchiveMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addTeacherAchive(TeacherAchive teacherAchive) {
        return teacherAchiveMapper.addTeacherAchive(teacherAchive);
    }

    @Override
    @Transactional
    public int deleteTeacherAchive(List<Integer> ids) {
        return teacherAchiveMapper.deleteTeacherAchive(ids);
    }

    @Override
    public int editTeacherAchive(TeacherAchive teacherAchive) {
        return teacherAchiveMapper.editTeacherAchive(teacherAchive);
    }

    @Override
    public TeacherAchive findByName(String teacherAchiveName) {
        return teacherAchiveMapper.findByName(teacherAchiveName);
    }

}

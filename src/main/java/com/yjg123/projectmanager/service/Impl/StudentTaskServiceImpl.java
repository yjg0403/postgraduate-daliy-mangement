package com.yjg123.projectmanager.service.Impl;


import com.yjg123.projectmanager.domain.StudentTask;
import com.yjg123.projectmanager.mapper.StudentTaskMapper;
import com.yjg123.projectmanager.service.StudentTaskService;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudentTaskServiceImpl
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Service
public class StudentTaskServiceImpl implements StudentTaskService {

    @Autowired
    private StudentTaskMapper studentTaskMapper;

    @Override
    public PageBean<StudentTask> queryPage(Map<String, Object> paramMap) {
        PageBean<StudentTask> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<StudentTask> datas = studentTaskMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = studentTaskMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addStudentTask(StudentTask studentTask) {
        return studentTaskMapper.addStudentTask(studentTask);
    }

    @Override
    @Transactional
    public int deleteStudentTask(List<Integer> ids) {
        return studentTaskMapper.deleteStudentTask(ids);
    }

    @Override
    public int editStudentTask(StudentTask studentTask) {
        return studentTaskMapper.editStudentTask(studentTask);
    }

    @Override
    public int updateIsRead(StudentTask studentTask) {
        return studentTaskMapper.updateIsRead(studentTask);
    }

    @Override
    public StudentTask findByName(String studentTaskName) {
        return studentTaskMapper.findByName(studentTaskName);
    }

}

package com.yjg123.projectmanager.service.Impl;


import com.yjg123.projectmanager.domain.StuAchive;
import com.yjg123.projectmanager.mapper.StuAchiveMapper;
import com.yjg123.projectmanager.service.StuAchiveService;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Classname StuAchiveServiceImpl
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Service
public class StuAchiveServiceImpl implements StuAchiveService {

    @Autowired
    private StuAchiveMapper stuAchiveMapper;

    @Override
    public PageBean<StuAchive> queryPage(Map<String, Object> paramMap) {
        PageBean<StuAchive> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<StuAchive> datas = stuAchiveMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = stuAchiveMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addStuAchive(StuAchive stuAchive) {
        return stuAchiveMapper.addStuAchive(stuAchive);
    }

    @Override
    @Transactional
    public int deleteStuAchive(List<Integer> ids) {
        return stuAchiveMapper.deleteStuAchive(ids);
    }

    @Override
    public int editStuAchive(StuAchive stuAchive) {
        return stuAchiveMapper.editStuAchive(stuAchive);
    }

    @Override
    public StuAchive findByName(String stuAchiveName) {
        return stuAchiveMapper.findByName(stuAchiveName);
    }

}

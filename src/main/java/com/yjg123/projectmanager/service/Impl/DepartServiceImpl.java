package com.yjg123.projectmanager.service.Impl;


import com.yjg123.projectmanager.domain.Depart;
import com.yjg123.projectmanager.mapper.DepartMapper;
import com.yjg123.projectmanager.service.DepartService;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Classname DepartServiceImpl
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartMapper departMapper;

    @Override
    public PageBean<Depart> queryPage(Map<String, Object> paramMap) {
        PageBean<Depart> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Depart> datas = departMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = departMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }



}

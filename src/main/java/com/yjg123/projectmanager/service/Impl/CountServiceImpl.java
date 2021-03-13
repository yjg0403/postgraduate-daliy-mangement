package com.yjg123.projectmanager.service.Impl;


import com.yjg123.projectmanager.domain.Count;
import com.yjg123.projectmanager.mapper.CountMapper;
import com.yjg123.projectmanager.service.CountService;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname CountServiceImpl
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private CountMapper countMapper;

    @Override
    public PageBean<Count> queryPage(Map<String, Object> paramMap) {
        PageBean<Count> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Count> datas = countMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = countMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }



}

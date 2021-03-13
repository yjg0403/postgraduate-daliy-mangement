package com.yjg123.projectmanager.mapper;

import com.yjg123.projectmanager.domain.StuAchive;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Classname StuAchiveMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface StuAchiveMapper {
    List<StuAchive> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addStuAchive(StuAchive stuAchive);

    int deleteStuAchive(List<Integer> ids);

    int editStuAchive(StuAchive stuAchive);

    StuAchive findByName(String stuAchiveName);
}

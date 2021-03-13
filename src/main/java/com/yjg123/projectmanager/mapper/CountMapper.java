package com.yjg123.projectmanager.mapper;

import com.yjg123.projectmanager.domain.Count;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Classname CountMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface CountMapper {
    List<Count> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

}

package com.yjg123.projectmanager.mapper;

import com.yjg123.projectmanager.domain.Admin;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserMapper
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Repository
public interface AdminMapper {

    Admin findByAdmin(Admin admin);



    int editPswdByAdmin(Admin admin);
}

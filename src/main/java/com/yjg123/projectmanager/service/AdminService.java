package com.yjg123.projectmanager.service;

import com.yjg123.projectmanager.domain.Admin;

/**
 * @Classname AdminService
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
public interface AdminService {

    Admin findByAdmin(Admin admin);


    int editPswdByAdmin(Admin admin);
}

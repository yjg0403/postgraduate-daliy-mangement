package com.yjg123.projectmanager.service.Impl;

import com.yjg123.projectmanager.domain.Admin;
import com.yjg123.projectmanager.mapper.AdminMapper;
import com.yjg123.projectmanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description None
 * @Date 2020/11/3
 * @Created by yjg
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findByAdmin(Admin admin) {
        return adminMapper.findByAdmin(admin);
    }

    @Override
    public int editPswdByAdmin(Admin admin) {
        return adminMapper.editPswdByAdmin(admin);
    }

}

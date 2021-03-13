package com.yjg123.projectmanager;

import com.yjg123.projectmanager.domain.Admin;
import com.yjg123.projectmanager.mapper.StudentTaskMapper;
import com.yjg123.projectmanager.mapper.TeamMapper;
import com.yjg123.projectmanager.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectManagerApplicationTests {

    @Autowired
    AdminService adminService;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    StudentTaskMapper studentTaskMapper;

   /* @Test
    void contextLoads() {
    }

    @Test
    void findAdmin(){

        Admin admin = new Admin();
        admin.setPassword("123456");
        admin.setUsername("admin");
        Admin ad = adminService.findByAdmin(admin);
        System.out.println(ad);
    }

    @Test
    void findTeachersByTeamTest(){
        System.out.println(teamMapper.findTeachersByTeam("2"));
    }

    @Test
    void findStudentsByTeamTest(){
        System.out.println(teamMapper.findStudentsByTeam("1"));
    }

    @Test
    void updateStateTest(){
        studentTaskMapper.updateState();
    }*/
}

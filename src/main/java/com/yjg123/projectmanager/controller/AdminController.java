package com.yjg123.projectmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname UserController
 * @Description 未做
 * @Date 2020/11/3
 * @Created by yjg
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/list")
    public String list(){
        return "/admin/admin_list";
    }
}

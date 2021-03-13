package com.yjg123.projectmanager.controller;

import com.yjg123.projectmanager.domain.Depart;
import com.yjg123.projectmanager.service.StudentService;
import com.yjg123.projectmanager.service.DepartService;
import com.yjg123.projectmanager.util.AjaxResult;
import com.yjg123.projectmanager.util.Data;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Classname DepartController
 * @Description 学院管理
 * @Date 2020/11/3
 * @Created by yjg
 */
@Controller
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    private DepartService departService;
    @Autowired
    private StudentService studentService;

    /**
     * 跳转学院页面（未做）
     * @return
     */
    @GetMapping("/depart_list")
    public String departList(){
        return "/depart/departList";
    }

    /**
     * 异步加载学院列表
     * @param page
     * @param rows
     * @return
     */
    @PostMapping("/getDepartList")
    @ResponseBody
    public Object getDepartList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        PageBean<Depart> pageBean = departService.queryPage(paramMap);
        return pageBean.getDatas();
    }
}

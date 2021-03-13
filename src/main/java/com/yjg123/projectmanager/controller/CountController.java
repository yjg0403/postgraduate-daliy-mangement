package com.yjg123.projectmanager.controller;

import com.yjg123.projectmanager.domain.Count;
import com.yjg123.projectmanager.domain.Depart;
import com.yjg123.projectmanager.service.CountService;
import com.yjg123.projectmanager.service.DepartService;
import com.yjg123.projectmanager.service.StudentService;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DepartController
 * @Description 小组管理
 * @Date 2020/11/3
 * @Created by yjg
 */
@Controller
@RequestMapping("/count")
public class CountController {

    @Autowired
    public CountService countService;

    @GetMapping("/studentCountList")
    public String studentCountList(){
        return "/count/studentCountList";
    }

    @GetMapping("/teacherCountList")
    public String teacherCountList(){
        return "/count/teacherCountList";
    }


    @GetMapping("/teamCountList")
    public String teamCountList(){
        return "/count/teamCountList";
    }

    /**
     * 异步加载小组列表
     * @param page
     * @param rows
     * @return
     */
    @PostMapping("/getCountList")
    @ResponseBody
    public Object getDepartList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                                String table,String from, HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!StringUtils.isEmpty(table) && table.equals("student")){
            paramMap.put("tableName","stu_statistic");
        }
        if(!StringUtils.isEmpty(table) && table.equals("teacher")){
            paramMap.put("tableName","teacher_statistic");
        }
        if(!StringUtils.isEmpty(table) && table.equals("team")){
            paramMap.put("tableName","group_statistics");
        }
        PageBean<Count> pageBean = countService.queryPage(paramMap);
        if(!StringUtils.isEmpty(from) && from.equals("combox")){
            return pageBean.getDatas();
        }else{
            Map<String,Object> result = new HashMap();
            result.put("total",pageBean.getTotalsize());
            result.put("rows",pageBean.getDatas());
            return result;
        }
    }
}

package com.yjg123.projectmanager.controller;

import com.yjg123.projectmanager.domain.StuAchive;
import com.yjg123.projectmanager.domain.Student;
import com.yjg123.projectmanager.domain.Teacher;
import com.yjg123.projectmanager.service.StudentService;
import com.yjg123.projectmanager.service.StuAchiveService;
import com.yjg123.projectmanager.util.AjaxResult;
import com.yjg123.projectmanager.util.Const;
import com.yjg123.projectmanager.util.Data;
import com.yjg123.projectmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname StuAchiveController
 * @Description 学生成果管理
 * @Date 2020/11/3
 * @Created by yjg
 */
@Controller
@RequestMapping("/stuAchive")
public class StuAchiveController {

    @Autowired
    private StuAchiveService stuAchiveService;
    @Autowired
    private StudentService studentService;

    /**
     * 跳转成果页面
     * @return
     */
    @GetMapping("/stuAchiveList")
    public String stuAchiveList(){
        return "/achivement/studentAchivement";
    }

    /**
     * 异步加载成果列表
     * @param page
     * @param rows
     * @param student
     * @return
     */
    @PostMapping("/getStuAchiveList")
    @ResponseBody
    public Object getStuAchiveList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                   @RequestParam(value = "rows", defaultValue = "100")Integer rows, String student,
                                   String type, String from, HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!StringUtils.isEmpty(student)) {
            paramMap.put("student",student);
        }
        if(!StringUtils.isEmpty(type)) {
            paramMap.put("type",type);
        }

        //判断是老师还是学生
        Student student1 = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student1)){
            //是学生权限，只能查询自己的信息
            paramMap.put("student",student1.getNo());
        }

        Teacher teacher1 = (Teacher) session.getAttribute(Const.TEACHER);
        if (!StringUtils.isEmpty(teacher1)) {
            //是老师权限，只能查询自己的信息
            paramMap.put("teacherNo", teacher1.getNo());
        }
        PageBean<StuAchive> pageBean = stuAchiveService.queryPage(paramMap);
        if(!StringUtils.isEmpty(from) && from.equals("combox")){
            return pageBean.getDatas();
        }else{
            Map<String,Object> result = new HashMap();
            result.put("total",pageBean.getTotalsize());
            result.put("rows",pageBean.getDatas());
            return result;
        }
    }

    /**
     * 添加成果
     * @param stuAchive
     * @return
     */
    @PostMapping("/addStuAchive")
    @ResponseBody
    public AjaxResult addStuAchive(StuAchive stuAchive){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = stuAchiveService.addStuAchive(stuAchive);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("添加成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加失败");
        }
        return ajaxResult;
    }

    /**
     * 删除成果
     * @param data
     * @return
     */
    @PostMapping("/deleteStuAchive")
    @ResponseBody
    public AjaxResult deleteStuAchive(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            List<Integer> nos = data.getNos();
            int count = stuAchiveService.deleteStuAchive(nos);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("删除成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("删除失败,存在学生关联");
        }
        return ajaxResult;
    }

    /**
     * 成果修改
     * @param stuAchive
     * @return
     */
    @PostMapping("/editStuAchive")
    @ResponseBody
    public AjaxResult editStuAchive(StuAchive stuAchive){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = stuAchiveService.editStuAchive(stuAchive);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("修改成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改失败");
        }
        return ajaxResult;
    }
}

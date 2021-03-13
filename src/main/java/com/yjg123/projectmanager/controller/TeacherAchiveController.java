package com.yjg123.projectmanager.controller;

import com.yjg123.projectmanager.domain.Teacher;
import com.yjg123.projectmanager.domain.TeacherAchive;
import com.yjg123.projectmanager.service.TeacherAchiveService;
import com.yjg123.projectmanager.service.TeacherService;
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
 * @Classname TeacherAchiveController
 * @Description 教师成果管理
 * @Date 2020/11/3
 * @Created by yjg
 */
@Controller
@RequestMapping("/teacherAchive")
public class TeacherAchiveController {

    @Autowired
    private TeacherAchiveService teacherAchiveService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 跳转成果页面
     * @return
     */
    @GetMapping("/teacherAchiveList")
    public String teacherAchiveList(){
        return "/achivement/teacherAchivement";
    }

    /**
     * 异步加载成果列表
     * @param page
     * @param rows
     * @param teacher
     * @return
     */
    @PostMapping("/getTeacherAchiveList")
    @ResponseBody
    public Object getTeacherAchiveList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                       @RequestParam(value = "rows", defaultValue = "100")Integer rows, String teacher,
                                       String type, String from, HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!StringUtils.isEmpty(teacher)) {
            paramMap.put("teacher",teacher);
        }
        Teacher teacher1 = (Teacher) session.getAttribute(Const.TEACHER);
        if (!StringUtils.isEmpty(teacher1)) {
            //是老师权限，只能查询自己的信息
            paramMap.put("teacher", teacher1.getNo());
        }
        if(!StringUtils.isEmpty(type)) {
            paramMap.put("type",type);
        }
        PageBean<TeacherAchive> pageBean = teacherAchiveService.queryPage(paramMap);
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
     * @param teacherAchive
     * @return
     */
    @PostMapping("/addTeacherAchive")
    @ResponseBody
    public AjaxResult addTeacherAchive(TeacherAchive teacherAchive){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = teacherAchiveService.addTeacherAchive(teacherAchive);
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
    @PostMapping("/deleteTeacherAchive")
    @ResponseBody
    public AjaxResult deleteTeacherAchive(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            List<Integer> nos = data.getNos();
            int count = teacherAchiveService.deleteTeacherAchive(nos);
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
     * @param teacherAchive
     * @return
     */
    @PostMapping("/editTeacherAchive")
    @ResponseBody
    public AjaxResult editTeacherAchive(TeacherAchive teacherAchive){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = teacherAchiveService.editTeacherAchive(teacherAchive);
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

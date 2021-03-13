package com.yjg123.projectmanager.controller;

import com.yjg123.projectmanager.domain.Student;
import com.yjg123.projectmanager.domain.StudentTask;
import com.yjg123.projectmanager.domain.Teacher;
import com.yjg123.projectmanager.service.StudentService;
import com.yjg123.projectmanager.service.StudentTaskService;
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
 * @Classname StudentTaskController
 * @Description 学生任务管理
 * @Date 2020/11/3
 * @Created by yjg
 */
@Controller
@RequestMapping("/studentTask")
public class StudentTaskController {

    @Autowired
    private StudentTaskService studentTaskService;
    @Autowired
    private StudentService studentService;

    /**
     * 跳转页面
     * @return
     */
    @GetMapping("/studentTaskList")
    public String studentTaskList(HttpSession session){
        Student student1 = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student1)){
            //是学生权限，只能查询自己的信息
            return "/task/studentTaskList1";
        }

        Teacher teacher = (Teacher) session.getAttribute(Const.TEACHER);
        if (!StringUtils.isEmpty(teacher)) {
            //是老师权限，只能查询自己的信息
            return "/task/studentTaskList2";
        }
        return "/task/studentTaskList";
    }


    /**
     * 异步加载列表
     * @param page
     * @param rows
     * @param student
     * @return
     */
    @PostMapping("/getStudentTaskList")
    @ResponseBody
    public Object getStudentTaskList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                     @RequestParam(value = "rows", defaultValue = "100")Integer rows, String student,
                                     String state,String from,String startTime,String endTime,String isRead,HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);

        Student student1 = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student1)){
            //是学生权限，只能查询自己的信息
            paramMap.put("student",student1.getNo());
        }

        Teacher teacher = (Teacher) session.getAttribute(Const.TEACHER);
        if (!StringUtils.isEmpty(teacher)) {
            //是老师权限，只能查询自己的信息
            paramMap.put("teacherNo", teacher.getNo());
        }

        if(!StringUtils.isEmpty(student)) {
            paramMap.put("student",student);
        }
        if(!StringUtils.isEmpty(state)) {
            paramMap.put("state",state);
        }
        if(!StringUtils.isEmpty(startTime)) {
            paramMap.put("startTime",startTime);
        }
        if(!StringUtils.isEmpty(endTime)) {
            paramMap.put("endTime",endTime);
        }

        if(!StringUtils.isEmpty(isRead)) {
            paramMap.put("isRead",isRead);
        }
        PageBean<StudentTask> pageBean = studentTaskService.queryPage(paramMap);
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
     * 添加小组
     * @param studentTask
     * @return
     */
    @PostMapping("/addStudentTask")
    @ResponseBody
    public AjaxResult addStudentTask(StudentTask studentTask, HttpSession session){
        AjaxResult ajaxResult = new AjaxResult();
        //判断是老师还是学生
        Student student = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student)){
            //是学生
            studentTask.setIsRead("否");
            studentTask.setState("任务进行中");
            studentTask.setStudent(student.getNo());
        }
        try {
            int count = studentTaskService.addStudentTask(studentTask);
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
     * 删除小组
     * @param data
     * @return
     */
    @PostMapping("/deleteStudentTask")
    @ResponseBody
    public AjaxResult deleteStudentTask(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            List<Integer> nos = data.getNos();
            int count = studentTaskService.deleteStudentTask(nos);
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
     * 小组修改
     * @param studentTask
     * @return
     */
    @PostMapping("/editStudentTask")
    @ResponseBody
    public AjaxResult editStudentTask(StudentTask studentTask,HttpSession session){
        AjaxResult ajaxResult = new AjaxResult();
        //判断是老师还是学生
        Student student = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student)){
            //是学生
            studentTask.setIsRead("否");
            studentTask.setStudent(student.getNo());
        }
        try {
            int count = studentTaskService.editStudentTask(studentTask);
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

    /**
     * 已读状态修改
     * @param
     * @return
     */
    @PostMapping("/updateIsRead")
    @ResponseBody
    public AjaxResult updateIsRead(StudentTask studentTask){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = studentTaskService.updateIsRead(studentTask);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("审阅成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("审阅失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("审阅失败");
        }
        return ajaxResult;
    }
}

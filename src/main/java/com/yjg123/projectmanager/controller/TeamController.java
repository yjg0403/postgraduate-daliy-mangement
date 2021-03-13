package com.yjg123.projectmanager.controller;

import com.yjg123.projectmanager.domain.Student;
import com.yjg123.projectmanager.domain.Teacher;
import com.yjg123.projectmanager.domain.Team;
import com.yjg123.projectmanager.mapper.TeamMapper;
import com.yjg123.projectmanager.service.TeamService;
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
 * @Classname TeamController
 * @Description 小组管理
 * @Date 2020/11/3
 * @Created by yjg
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamMapper teamMapper;

    /**
     * 跳转小组页面
     * @return
     */
    @GetMapping("/team_list")
    public String teamList(){
        return "/team/teamList";
    }

    /**
     * 异步加载小组列表
     * @param page
     * @param rows
     * @param name
     * @return
     */
    @PostMapping("/getTeamList")
    @ResponseBody
    public Object getTeamList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                              @RequestParam(value = "rows", defaultValue = "100")Integer rows, String name,
                              String teacher, String from, HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!StringUtils.isEmpty(name)) {
            paramMap.put("name",name);
        }
        if(!StringUtils.isEmpty(teacher)) {
            paramMap.put("teacher",teacher);
        }
        //判断是老师还是学生
        Student student1 = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student1)){
            //是学生权限，只能查询自己的信息
            paramMap.put("studentNo",student1.getNo());
        }

        Teacher teacher1 = (Teacher) session.getAttribute(Const.TEACHER);
        if (!StringUtils.isEmpty(teacher1)) {
            //是老师权限，只能查询自己的信息
            paramMap.put("teacher", teacher1.getNo());
        }

        PageBean<Team> pageBean = teamService.queryPage(paramMap);
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
     * @param team
     * @return
     */
    @PostMapping("/addTeam")
    @ResponseBody
    public AjaxResult addTeam(Team team){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = teamService.addTeam(team);
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
    @PostMapping("/deleteTeam")
    @ResponseBody
    public AjaxResult deleteTeam(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            List<Integer> nos = data.getNos();
            //Iterator<Integer> iterator = ids.iterator();
//            while (iterator.hasNext()){  //判断是否存在课程关联学生
//                if(!studentService.isStudentByTeamId(iterator.next())){
//                    ajaxResult.setSuccess(false);
//                    ajaxResult.setMessage("无法删除,小组下存在学生");
//                    return ajaxResult;
//                }
//            }
            int count = teamService.deleteTeam(data.getNos());
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
            ajaxResult.setMessage("删除失败,该小组存在老师或学生");
        }
        return ajaxResult;
    }

    /**
     * 小组修改
     * @param team
     * @return
     */
    @PostMapping("/editTeam")
    @ResponseBody
    public AjaxResult editTeam(Team team){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = teamService.editTeam(team);
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
     * 获取小组下的所有老师
     * @param team
     * @return
     */
    @PostMapping("/findTeachersByTeam")
    @ResponseBody
    public Object findTeachersByTeam(String team){
        return teamService.findTeachersByTeam(team);
    }
    
    /**
     * 获取小组下的所有学生
     * @param team
     * @return
     */
    @PostMapping("/findStudentsByTeam")
    @ResponseBody
    public Object findStudentsByTeam(String team){
        return teamService.findStudentsByTeam(team);
    }


    /**
     * 添加老师
     * @return
     */
    @PostMapping("/addTeacher")
    @ResponseBody
    public AjaxResult addTeacher(String no,String teacher){
        AjaxResult ajaxResult = new AjaxResult();
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("no",no);
        paramMap.put("teacher",teacher);
        try {
            int count = teamMapper.addTeacher(paramMap);
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
     * 添加学生
     * @return
     */
    @PostMapping("/addStudent")
    @ResponseBody
    public AjaxResult addStudent(String no,String student){
        AjaxResult ajaxResult = new AjaxResult();
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("no",no);
        paramMap.put("student",student);
        try {
            int count = teamMapper.addStudent(paramMap);
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
     * 删除学生
     * @return
     */
    @PostMapping("/deleteStudent")
    @ResponseBody
    public AjaxResult deleteStudent(String no,String student){
        AjaxResult ajaxResult = new AjaxResult();
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("no",no);
        paramMap.put("student",student);
        try {
            int count = teamMapper.deleteStudent(paramMap);
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
            ajaxResult.setMessage("删除失败");
        }
        return ajaxResult;
    }


    /**
     * 删除老师
     * @return
     */
    @PostMapping("/deleteTeacher")
    @ResponseBody
    public AjaxResult deleteTeacher(String no,String teacher){
        AjaxResult ajaxResult = new AjaxResult();
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("no",no);
        paramMap.put("teacher",teacher);
        try {
            int count = teamMapper.deleteTeacher(paramMap);
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
            ajaxResult.setMessage("删除失败");
        }
        return ajaxResult;
    }
    
}

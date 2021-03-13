package com.yjg123.projectmanager.domain;

/**
 * @author JackYjg
 * @date 2020/12/11 0:18
 */
public class Count {
    private String name;
    private String studentNum;
    private String teacherNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    @Override
    public String toString() {
        return "Count{" +
                "name='" + name + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", teacherNum='" + teacherNum + '\'' +
                '}';
    }
}

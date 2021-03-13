package com.yjg123.projectmanager.domain;

import java.io.Serializable;

/**
 * 学生实体类
 *
 * @author dell
 */
public class Student {
    private String no;
    private String name;
    private String sex;
    private int age;
    private String depart;
    private String teacher;
    private String team;
    private String mobile;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", depart='" + depart + '\'' +
                ", teacher='" + teacher + '\'' +
                ", team='" + team + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

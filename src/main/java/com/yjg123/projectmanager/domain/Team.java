package com.yjg123.projectmanager.domain;

/**
 * @author JackYjg
 * @date 2020/12/4 20:21
 */
public class Team {
    private String no;
    private String name;
    private String labor;
    private String teacher;

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

    public String getLabor() {
        return labor;
    }

    public void setLabor(String labor) {
        this.labor = labor;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Team{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", labor='" + labor + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}

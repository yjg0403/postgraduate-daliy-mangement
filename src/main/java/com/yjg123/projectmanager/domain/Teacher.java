package com.yjg123.projectmanager.domain;


/**
 * @author dell
 * 教师实体类
 */
public class Teacher {
    private String no;
    private String name;
    private String password;
    private String sex;
    private int age;
    private String title;
    private String depart;
    private String mobile;
    private String info;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", title='" + title + '\'' +
                ", depart='" + depart + '\'' +
                ", mobile='" + mobile + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}

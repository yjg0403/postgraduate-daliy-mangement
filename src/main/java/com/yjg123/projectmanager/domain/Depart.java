package com.yjg123.projectmanager.domain;

/**
 * @author JackYjg
 * @date 2020/12/4 20:19
 */
public class Depart {
    private  String no;
    private String name;

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

    @Override
    public String toString() {
        return "Depart{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

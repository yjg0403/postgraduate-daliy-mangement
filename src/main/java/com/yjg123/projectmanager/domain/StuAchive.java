package com.yjg123.projectmanager.domain;


/**
 * @author JackYjg
 * @date 2020/12/8 20:05
 */
public class StuAchive {
    private String id;
    private String content;
    private String student;
    private String type;
    private String info;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "StuAchive{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", student='" + student + '\'' +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}

package com.yjg123.projectmanager.domain;


import java.sql.Date;

/**
 * @author JackYjg
 * @date 2020/12/7 10:15
 */
public class StudentTask {
    private int id;
    private String student;
    private String content;
    private Date startTime;
    private Date endTime;
    private String schedule;
    private String state;
    private String isRead;
    private String suggest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Override
    public String toString() {
        return "StudentTask{" +
                "id=" + id +
                ", student='" + student + '\'' +
                ", content='" + content + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", schedule='" + schedule + '\'' +
                ", state='" + state + '\'' +
                ", isRead='" + isRead + '\'' +
                ", suggest='" + suggest + '\'' +
                '}';
    }
}

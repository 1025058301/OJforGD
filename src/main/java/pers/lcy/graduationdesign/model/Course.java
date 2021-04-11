package pers.lcy.graduationdesign.model;

import java.util.Date;

public class Course {
    private Integer id;

    private String courseName;

    private String teacherName;

    private Date startTime;

    public Course(Integer id, String courseName, String teacherName, Date startTime) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.startTime = startTime;
    }

    public Course() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
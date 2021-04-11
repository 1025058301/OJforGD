package pers.lcy.graduationdesign.model;

import java.util.Date;

public class Homework {
    private Integer id;

    private String workName;

    private Integer teacherId;

    private Integer couseId;

    private Integer problemId;

    private Date publishTime;

    private Date deadline;

    private Integer state;

    public Homework(Integer id, String workName, Integer teacherId, Integer couseId, Integer problemId, Date publishTime, Date deadline, Integer state) {
        this.id = id;
        this.workName = workName;
        this.teacherId = teacherId;
        this.couseId = couseId;
        this.problemId = problemId;
        this.publishTime = publishTime;
        this.deadline = deadline;
        this.state = state;
    }

    public Homework() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCouseId() {
        return couseId;
    }

    public void setCouseId(Integer couseId) {
        this.couseId = couseId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
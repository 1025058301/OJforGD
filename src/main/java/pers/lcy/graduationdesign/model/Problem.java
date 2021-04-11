package pers.lcy.graduationdesign.model;

import java.util.Date;

public class Problem {
    private Integer id;

    private Integer fromTeacherId;

    private String problemName;

    private String problemContent;

    private String problemKnowledge;

    private String testCase;

    private Date publishTime;

    private Integer state;

    public Problem(Integer id, Integer fromTeacherId, String problemName, String problemContent, String problemKnowledge, String testCase, Date publishTime, Integer state) {
        this.id = id;
        this.fromTeacherId = fromTeacherId;
        this.problemName = problemName;
        this.problemContent = problemContent;
        this.problemKnowledge = problemKnowledge;
        this.testCase = testCase;
        this.publishTime = publishTime;
        this.state = state;
    }

    public Problem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromTeacherId() {
        return fromTeacherId;
    }

    public void setFromTeacherId(Integer fromTeacherId) {
        this.fromTeacherId = fromTeacherId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName == null ? null : problemName.trim();
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent == null ? null : problemContent.trim();
    }

    public String getProblemKnowledge() {
        return problemKnowledge;
    }

    public void setProblemKnowledge(String problemKnowledge) {
        this.problemKnowledge = problemKnowledge == null ? null : problemKnowledge.trim();
    }

    public String getTestCase() {
        return testCase;
    }

    public void setTestCase(String testCase) {
        this.testCase = testCase == null ? null : testCase.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
package pers.lcy.graduationdesign.model;

public class ProblemPerson {
    private Integer id;

    private Integer teacherId;

    private Integer problemId;

    public ProblemPerson(Integer id, Integer teacherId, Integer problemId) {
        this.id = id;
        this.teacherId = teacherId;
        this.problemId = problemId;
    }

    public ProblemPerson() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }
}
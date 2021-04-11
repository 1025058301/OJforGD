package pers.lcy.graduationdesign.model;

public class HomeworkInfo {
    private Integer id;

    private Integer homeworkId;

    private Integer studentId;

    private Integer score;

    private Integer state;

    public HomeworkInfo(Integer id, Integer homeworkId, Integer studentId, Integer score, Integer state) {
        this.id = id;
        this.homeworkId = homeworkId;
        this.studentId = studentId;
        this.score = score;
        this.state = state;
    }

    public HomeworkInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
package pers.lcy.graduationdesign.model;

public class CourseSelectInfo {
    private Integer id;

    private Integer courseId;

    private Integer studentId;

    public CourseSelectInfo(Integer id, Integer courseId, Integer studentId) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public CourseSelectInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
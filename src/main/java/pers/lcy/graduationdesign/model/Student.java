package pers.lcy.graduationdesign.model;

public class Student {
    private Integer id;

    private String studentName;

    private Integer classId;

    private Integer userId;

    public Student(Integer id, String studentName, Integer classId, Integer userId) {
        this.id = id;
        this.studentName = studentName;
        this.classId = classId;
        this.userId = userId;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
package pers.lcy.graduationdesign.model;

public class Class {
    private Integer id;

    private String className;

    public Class(Integer id, String className) {
        this.id = id;
        this.className = className;
    }

    public Class() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}
package com.neuedu.ruidaoexam.entity;

public class AnsweredPaper {
    private Integer ansPaperId;

    private Integer paperId;

    private Integer stuId;

    private Integer checkedbyteacherid;

    private String isModifiedByTeacher;

    public Integer getAnsPaperId() {
        return ansPaperId;
    }

    public void setAnsPaperId(Integer ansPaperId) {
        this.ansPaperId = ansPaperId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getCheckedbyteacherid() {
        return checkedbyteacherid;
    }

    public void setCheckedbyteacherid(Integer checkedbyteacherid) {
        this.checkedbyteacherid = checkedbyteacherid;
    }

    public String getIsModifiedByTeacher() {
        return isModifiedByTeacher;
    }

    public void setIsModifiedByTeacher(String isModifiedByTeacher) {
        this.isModifiedByTeacher = isModifiedByTeacher == null ? null : isModifiedByTeacher.trim();
    }
}
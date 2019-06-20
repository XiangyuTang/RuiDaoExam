package com.neuedu.ruidaoexam.entity;

public class QuestionBank {
    private Integer quesBankId;

    private String quesBankName;

    private Integer quesBankFiled;

    private Integer createdbyteacherid;

    private Integer pointPrice;

    public Integer getQuesBankId() {
        return quesBankId;
    }

    public void setQuesBankId(Integer quesBankId) {
        this.quesBankId = quesBankId;
    }

    public String getQuesBankName() {
        return quesBankName;
    }

    public void setQuesBankName(String quesBankName) {
        this.quesBankName = quesBankName == null ? null : quesBankName.trim();
    }

    public Integer getQuesBankFiled() {
        return quesBankFiled;
    }

    public void setQuesBankFiled(Integer quesBankFiled) {
        this.quesBankFiled = quesBankFiled;
    }

    public Integer getCreatedbyteacherid() {
        return createdbyteacherid;
    }

    public void setCreatedbyteacherid(Integer createdbyteacherid) {
        this.createdbyteacherid = createdbyteacherid;
    }

    public Integer getPointPrice() {
        return pointPrice;
    }

    public void setPointPrice(Integer pointPrice) {
        this.pointPrice = pointPrice;
    }
}
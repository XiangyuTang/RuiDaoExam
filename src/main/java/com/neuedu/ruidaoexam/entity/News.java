package com.neuedu.ruidaoexam.entity;

import java.util.Date;

public class News {
    private Integer newsId;

    private Integer receiveTypeId;

    private Integer receiveTeacherId;

    private Integer receiveStudentId;

    private Integer sendTypeId;

    private Integer sendTeacherId;

    private Integer sendStudentId;

    private String sendName;

    private Integer newsType;

    private Date newsTime;

    private String newsContent;

    private Integer isRead;

    private String reserve1;

    private Integer reserve2;

    public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(Integer newsId, Integer receiveTypeId, Integer receiveTeacherId, Integer receiveStudentId,
			Integer sendTypeId, Integer sendTeacherId, Integer sendStudentId, String sendName, Integer newsType,
			Date newsTime, String newsContent, Integer isRead, String reserve1, Integer reserve2) {
		super();
		this.newsId = newsId;
		this.receiveTypeId = receiveTypeId;
		this.receiveTeacherId = receiveTeacherId;
		this.receiveStudentId = receiveStudentId;
		this.sendTypeId = sendTypeId;
		this.sendTeacherId = sendTeacherId;
		this.sendStudentId = sendStudentId;
		this.sendName = sendName;
		this.newsType = newsType;
		this.newsTime = newsTime;
		this.newsContent = newsContent;
		this.isRead = isRead;
		this.reserve1 = reserve1;
		this.reserve2 = reserve2;
	}

	public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getReceiveTypeId() {
        return receiveTypeId;
    }

    public void setReceiveTypeId(Integer receiveTypeId) {
        this.receiveTypeId = receiveTypeId;
    }

    public Integer getReceiveTeacherId() {
        return receiveTeacherId;
    }

    public void setReceiveTeacherId(Integer receiveTeacherId) {
        this.receiveTeacherId = receiveTeacherId;
    }

    public Integer getReceiveStudentId() {
        return receiveStudentId;
    }

    public void setReceiveStudentId(Integer receiveStudentId) {
        this.receiveStudentId = receiveStudentId;
    }

    public Integer getSendTypeId() {
        return sendTypeId;
    }

    public void setSendTypeId(Integer sendTypeId) {
        this.sendTypeId = sendTypeId;
    }

    public Integer getSendTeacherId() {
        return sendTeacherId;
    }

    public void setSendTeacherId(Integer sendTeacherId) {
        this.sendTeacherId = sendTeacherId;
    }

    public Integer getSendStudentId() {
        return sendStudentId;
    }

    public void setSendStudentId(Integer sendStudentId) {
        this.sendStudentId = sendStudentId;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName == null ? null : sendName.trim();
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public Integer getReserve2() {
        return reserve2;
    }

    public void setReserve2(Integer reserve2) {
        this.reserve2 = reserve2;
    }
}
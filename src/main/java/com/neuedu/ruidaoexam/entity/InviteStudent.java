package com.neuedu.ruidaoexam.entity;

import java.sql.Timestamp;
import java.util.Date;

public class InviteStudent {
    private Integer inviteId;

    private Integer paperId;

    private Integer teacherId;

    private Integer studentId;

    private Date beginTime;

	private Date endTime;

    private String inviteCode;

    private Integer isreaded;
    
    public InviteStudent(Integer inviteId, Integer paperId, Integer teacherId, Integer studentId, Timestamp beginTime,
			Timestamp endTime, String inviteCode, Integer isreaded) {
    	super();
		this.inviteId = inviteId;
		this.paperId = paperId;
		this.teacherId = teacherId;
		this.studentId = studentId;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.inviteCode = inviteCode;
		this.isreaded = isreaded;
    }

    public InviteStudent(Integer inviteId, Integer paperId, Integer teacherId, Integer studentId, Date beginTime,
			Date endTime, String inviteCode, Integer isreaded) {
		super();
		this.inviteId = inviteId;
		this.paperId = paperId;
		this.teacherId = teacherId;
		this.studentId = studentId;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.inviteCode = inviteCode;
		this.isreaded = isreaded;
	}

    public Integer getInviteId() {
        return inviteId;
    }

    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    public Integer getIsreaded() {
        return isreaded;
    }

    public void setIsreaded(Integer isreaded) {
        this.isreaded = isreaded;
    }
}
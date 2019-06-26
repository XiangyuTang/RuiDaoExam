package com.neuedu.ruidaoexam.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MsgOfInvite {
	private String name;
	private String email;
	
	public MsgOfInvite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MsgOfInvite(String name, String email, Date begintime, Date endtime, Integer cheattimes, Integer teacherid,
			Integer paperid) {
		super();
		this.name = name;
		this.email = email;
		this.begintime = begintime;
		this.endtime = endtime;
		this.cheattimes = cheattimes;
		this.teacherid = teacherid;
		this.paperid = paperid;
	}
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
	private Date begintime;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
	private Date endtime;
	private Integer cheattimes;
	private Integer teacherid;
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	public Integer getPaperid() {
		return paperid;
	}
	public void setPaperid(Integer paperid) {
		this.paperid = paperid;
	}
	private Integer paperid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getCheattimes() {
		return cheattimes;
	}
	public void setCheattimes(Integer cheattimes) {
		this.cheattimes = cheattimes;
	}
	public String getDatePoor(Date endDate, Date nowDate) {
		 
	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - nowDate.getTime();
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	    if(day>0)
	    	return day + "天" + hour + "小时" + min + "分钟";
	    else if(hour>0)
	    	return hour + "小时" + min + "分钟";
	    else
	    	return min + "分钟";
	}
}

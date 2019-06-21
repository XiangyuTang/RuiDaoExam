package com.neuedu.ruidaoexam.jms.queue;

import com.neuedu.ruidaoexam.entity.MsgOfInvite;

public class TempObject {
	private MsgOfInvite msg;
	private String invitecode;
	
	public TempObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TempObject(MsgOfInvite msg, String invitecode) {
		super();
		this.msg = msg;
		this.invitecode = invitecode;
	}
	
	public MsgOfInvite getMsg() {
		return msg;
	}
	public void setMsg(MsgOfInvite msg) {
		this.msg = msg;
	}
	public String getInvitecode() {
		return invitecode;
	}
	
	public void setInvitecode(String invitecode) {
		this.invitecode = invitecode;
	}
	
}

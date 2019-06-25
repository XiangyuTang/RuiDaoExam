package com.neuedu.ruidaoexam.service;

import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.entity.Student;

public interface InviteService {
	void sendEmail(MsgOfInvite msg,String inviteCode);

	int addInviteMsg(MsgOfInvite msg, String invitecode);

	InviteStudent verifyPerson(String email, String invitecode);
}

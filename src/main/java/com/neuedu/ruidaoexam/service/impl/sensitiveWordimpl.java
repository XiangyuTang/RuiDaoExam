package com.neuedu.ruidaoexam.service.impl;

import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.SensitiveWordFilteringUtil.BadWordUtil2;
import com.neuedu.ruidaoexam.service.SensitiveWordService;

@Service
public class sensitiveWordimpl implements SensitiveWordService{

	@Override
	public String replaceBadWord(String txt, int matchType, String replaceChar) {
		return BadWordUtil2.replaceBadWord(txt, 2, "*");
	}

}

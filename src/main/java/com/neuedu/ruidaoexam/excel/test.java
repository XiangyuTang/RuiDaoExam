package com.neuedu.ruidaoexam.excel;

import com.alibaba.excel.annotation.ExcelProperty;

public class test {
	 @ExcelProperty(index = 0 , value = "姓名")
	 private String email;
	 public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
}

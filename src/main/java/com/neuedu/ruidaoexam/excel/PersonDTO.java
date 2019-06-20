package com.neuedu.ruidaoexam.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
/**
 * 要操作excel的实体类
 * @ExcelProperty 注解表示该注解定义的属性,可以读写excel表
 * @author lgp
 *
 */
public class PersonDTO extends BaseRowModel {


	/** 姓名 **/
    @ExcelProperty(index = 0 , value = "姓名")
    private String name;
    
    /** 邮箱 **/
    @ExcelProperty(index = 1 , value = "身份ID")
    private String email;
    
    
	public PersonDTO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public PersonDTO() {
		super();
	}   

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

	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", email=" + email + "]";
	}
    
    
    
}

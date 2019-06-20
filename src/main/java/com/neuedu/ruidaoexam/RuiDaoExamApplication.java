package com.neuedu.ruidaoexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.neuedu.ruidaoexam.dao"})
public class RuiDaoExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuiDaoExamApplication.class, args);
	}

}

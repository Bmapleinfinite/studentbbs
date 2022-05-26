package com.example.studentbbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.studentbbs.dao")
public class StudentbbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentbbsApplication.class, args);
	}
}

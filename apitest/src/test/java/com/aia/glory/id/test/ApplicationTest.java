package com.aia.glory.id.test;

import com.aia.glory.id.TestReports;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.aia.glory.id")
public class ApplicationTest  {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationTest.class,args);
    }

}
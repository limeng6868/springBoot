package com.it.myspringboot;


import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class MyspringbootApplication {

	public static void main(String[] args)
	{
		System.out.println("---------------------------------");
		System.out.println("----------------------------");
		SpringApplication.run(MyspringbootApplication.class, args);
	}
	@Before("/")
	public void test(){
		System.out.println("------------------1111111111111111111111111111");
	}
}

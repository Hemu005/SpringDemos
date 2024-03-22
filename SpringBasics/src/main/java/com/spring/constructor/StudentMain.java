package com.spring.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.setter.Employee;

public class StudentMain {
public static void main(String[] args) {
	
	ApplicationContext context=new AnnotationConfigApplicationContext("com.spring.constructor");
	
	Student student=(Student) context.getBean("student");
	System.out.println(student);
}
}

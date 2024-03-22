package com.spring.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {
	
public static void main(String[] args) {
	
	ApplicationContext context=new AnnotationConfigApplicationContext("com.spring.setter");
	
	Employee employee=(Employee) context.getBean("employee");
	System.out.println(employee);
	
	Employee employee1=context.getBean("employee",Employee.class);
	System.out.println(employee1);
	
	Employee employee2=context.getBean(Employee.class);
	System.out.println(employee2);
	
	String[] beans=context.getBeanDefinitionNames();
	for(String bean:beans) {
		System.out.println(bean);
	}
}
}

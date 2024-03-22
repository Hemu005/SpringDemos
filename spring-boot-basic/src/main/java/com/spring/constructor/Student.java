package com.spring.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Student {
	
private String studName;
private String dept;
private Course course;

//His course will be injected using constructor
//annotation autowired not required
public Student(Course course) {
	super();
	this.course = course;
}
public String getStudName() {
	return studName;
}
@Value("${student.studName}")
public void setStudName(String studName) {
	this.studName = studName;
}

public String getDept() {
	return dept;
}
@Value("${student.dept}")
public void setDept(String dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return "Student [studName=" + studName + ", dept=" + dept + ", course=" + course + "]";
}

}

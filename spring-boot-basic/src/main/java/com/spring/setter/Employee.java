package com.spring.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
private  String empName;
private Integer empId;
private Address address;

public Employee() {
	super();
	
}
public Employee(String empName, Integer empId, Address address) {
	super();
	this.empName = empName;
	this.empId = empId;
	this.address=address;
}
public String getEmpName() {
	return empName;
}
@Value("Beem")
public void setEmpName(String empName) {
	this.empName = empName;
}
public Integer getEmpId() {
	return empId;
}
@Value("11")
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public Address getAddress(){
	return address;
}
@Autowired
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Employee [empName=" + empName + ", empId=" + empId + ", address=" + address + "]";
}

}

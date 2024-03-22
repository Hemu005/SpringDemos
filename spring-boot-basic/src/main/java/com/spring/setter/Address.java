package com.spring.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
private String city;
private String state;
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
public Address(String city, String state) {
	super();
	this.city = city;
	this.state = state;
}
public String getCity() {
	return city;
}
@Value("Mandya")
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
@Value("Karnataka")
public void setState(String state) {
	this.state = state;
}
@Override
public String toString() {
	return "Address [city=" + city + ", state=" + state + "]";
}

}

package com.example.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements IShape{

	public void area(int x, int y) {
		System.out.println("Area of Rectangle: "+(x*y));
		
	}

}

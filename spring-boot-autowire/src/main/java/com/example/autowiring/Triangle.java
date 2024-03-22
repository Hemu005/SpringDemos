package com.example.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements IShape{

	public void area(int x, int y) {
      System.out.println("Area of triangle: "+(0.5*x*y));
		
	}

}

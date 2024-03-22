package com.example.javabased;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

public class Indian implements IFoodMenu{

	public List<String> showMenu() {
		List<String> indian=Arrays.asList("Mutton Biriyani","Chicken Kabab");
		return indian;
	}

}

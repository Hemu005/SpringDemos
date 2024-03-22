package com.example.javabased;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

public class Chinese implements IFoodMenu{

	public List<String> showMenu() {
		List<String> chinese=Arrays.asList("Gobi Manchurian","Noodles");
		return chinese;
	}

}

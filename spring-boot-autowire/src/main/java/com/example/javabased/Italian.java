package com.example.javabased;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

public class Italian implements IFoodMenu{

	public List<String> showMenu() {
		List<String> italian=Arrays.asList("thiramisu","italian brunch");
		return italian;
	}

}

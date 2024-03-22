package com.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class ShapeFactory {
	//autowiring by type
@Autowired	
@Qualifier("rectangle")	
private IShape iShape;

//autowiring by name
@Autowired
private IShape triangle;
//by constructor
private IShape shaper;
public ShapeFactory(IShape shaper) {
	super();
	this.shaper=shaper;
}

public IShape getiShape() {
	return iShape;
}

public void setiShape(IShape iShape) {
	this.iShape = iShape;
}

void printArea(String choice,int x,int y) {
	if(choice.equals("r"))
		iShape.area(x, y);
	if(choice.equals("t"))
		triangle.area(x, y);
	if(choice.equals("s"))
		shaper.area(x, y);
}
}

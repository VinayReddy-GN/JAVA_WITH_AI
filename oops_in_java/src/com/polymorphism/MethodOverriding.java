package com.polymorphism;

class Shape{
	public void draw() {
		System.out.println("drawing a shape!!");
		
	}
}
class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("drawing a circle!!!");
	}
}

class Rectangle extends Shape{

	@Override
	public void draw() {
		System.out.println("drawing a rectangle!!");
	}
	
}
//method over loading is a run time polymorphism
public class MethodOverriding {
	public static void main(String[] args) {
		Shape s1 = new Circle();
		s1.draw();
		Shape s2 = new Rectangle();
		s2.draw();
	}

}

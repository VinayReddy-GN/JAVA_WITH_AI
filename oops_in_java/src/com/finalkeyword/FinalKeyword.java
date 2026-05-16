package com.finalkeyword;

 final class Parent{
	public void display() {
		System.out.println("parent method");
	}
}


	@Override
	public void display() {
		System.out.println("child method");
	}
	
}

public class FinalKeyword {
	public static void main(String[] args) {
		//1.variable
		final double pi = 3.14;
		System.out.println("PI value is :"+pi);
		//pi = 3.14; we can't add the value becz all ready we gave the value to the final keyword to that variables
		final int marks;
		marks = 235;
		//marks = 456; we can't add here 
	}

}

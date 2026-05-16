package com.UnCheckedException;

public class UncheckedException2 {
	public static void main(String[] args) {
		System.out.println("program starts");
		String str[] = { "ABC","DEF","GHI","JKL","MLO"};

		System.out.println("accessing the 5th element");
		try {
			System.out.println("ele:"+str[8]);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("program closed");
		
		
	}

}

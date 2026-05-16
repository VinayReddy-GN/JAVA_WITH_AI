package com.UnCheckedException;

public class UncheckedException {
	public static void main(String[] args) {
		System.out.println("program starts");
		int arr[] = { 11,22,33,44,55};
		System.out.println("accessing the 5th element");
		try {
			System.out.println("ele:"+arr[5]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("program closed");
		
		
	}

}

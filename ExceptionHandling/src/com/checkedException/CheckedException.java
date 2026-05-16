package com.checkedException;

import java.io.PrintWriter;

public class CheckedException {
	public static void main(String[] args)  {
		PrintWriter a = null;
		//checked exception
		PrintWriter pw = a;
		try {
			pw = new PrintWriter("xyz.txt");
			pw.write("Hello World!! This is java programing");
			System.out.println("done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("=============");
			System.out.println(e.getMessage());
			System.out.println("=============");
			System.out.println(e);
		}finally {
			pw.close();
			System.out.println("File is closed!!");
		}
		
		
		System.out.println("Successfull!!!");
	}

}

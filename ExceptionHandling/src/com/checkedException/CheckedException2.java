package com.checkedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedException2 {
	public static void main(String[] args)  {
		File f = new File("abc.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine());{
				System.out.println(sc.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("===============");
			System.out.println(e.getMessage());
			System.out.println("===============");
			System.out.println(e);
		}finally {
			sc.close();
		}
		System.out.println("-----------");
		System.out.println("successfull");
		
	}

}

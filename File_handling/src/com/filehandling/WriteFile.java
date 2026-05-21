package com.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	public static void main(String[] args) throws IOException {
		FileWriter fileWriter = new FileWriter("sample.txt");
		fileWriter.write("Hello world");
		fileWriter.write("\n");
		fileWriter.write("this is a java programming!!");
		fileWriter.write("\n");
		fileWriter.write("this is the end");
		fileWriter.close();
		System.out.println("completed");
		
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sample1.txt"));
		bufferedWriter.write("Hello world");
		bufferedWriter.write("\n");
		bufferedWriter.write("this is a java programming!!");
		bufferedWriter.write("\n");
		bufferedWriter.write("this is the end");
		bufferedWriter.close();
		System.out.println("completed");
		
	}

}

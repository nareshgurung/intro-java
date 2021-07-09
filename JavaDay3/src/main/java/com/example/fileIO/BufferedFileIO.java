package com.example.fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileIO {
	public static void main(String[] args) {
		String filename = "bufferedFile.text";
		writeBufferedSteam(filename, "Hello, we are writing to a character String");
		readBufferedSteam(filename);
	}

		private static void writeBufferedSteam(String filename, String message) {
			try {
				BufferedWriter write = new BufferedWriter (new FileWriter(filename, true));
				write.write(message);
				write.newLine();
				write.flush();
				write.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	private static void readBufferedSteam(String filename) {
		try {
			BufferedReader read = new BufferedReader(new FileReader(filename));
			String line = "";
			while((line = read.readLine()) != null){ 
				System.out.println(line);
					}
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}

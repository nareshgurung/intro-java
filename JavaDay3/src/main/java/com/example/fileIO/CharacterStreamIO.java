package com.example.fileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamIO {
	
	public static void main(String[] args) {
		String filename = "CharacterStream.text";
		
		writerCharacterStream(filename, "hello, we are writring to a character stream");
		readCharacterStream(filename);
	}
	
	private static void writerCharacterStream(String filename, String message) {
		try {
			//the file writer constructor takes in the filename, and a boolean for if it should append or overrid ethe file
			FileWriter writer = new FileWriter(filename, true);
			writer.write(message);
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static void readCharacterStream(String filename) {
		try {
			FileReader read = new FileReader(filename);
			int i;
			while((i = read.read()) != -1) {
				System.out.println((char)i);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

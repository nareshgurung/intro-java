package com.example.fileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerIO {

	
		private static ObjectIO<User> io = new ObjectIO<User>();
		private static final String file = "users.text";
		
		public static void main(String[] args) {
			//to get user input you can use the scanner class 
			Scanner scan = new Scanner(System.in);
			
			ArrayList<User> users = null;
			
			try {
				users = io.readObjects(file);
			}catch(FileNotFoundException e){
				System.out.println("the users file does not exist yet");
				users = new ArrayList<User>();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Please enter your first name: ");
			String first = scan.nextLine();
			System.out.println("please enter you lastname: ");
			String last = scan.nextLine();
			System.out.println("please enter a password: ");
			String pass = scan.nextLine();
			
			User u = new User(first, last, pass);
			
			users.add(u);
			
			io.writeObjects(file, users);
			System.out.println("your username is: "+ u.getUsername());
			
			System.out.println("Other registerd users inclued: ");
			try {
				users = io.readObjects(file);
			}catch(ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			for(int i=0; i<users.size(); i++) {
				System.out.println(users.get(i).getUsername());
			}
			scan.close();
		}
}

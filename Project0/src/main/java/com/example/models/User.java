package com.example.models;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
		private String firstName;
		private String lastName;
		private String password;
		private String userName;
		
		//empty constructor
		public User() {
			super();
		}
		//parameterize constructor
		public User(String firstName, String lastName, String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.userName = firstName + lastName + (new Random().nextInt(9000)+ 1000);
		}
		
		//getter and setters
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUserName() {
			return userName;
		}
		@Override
		public String toString() {
			return "user [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", userName="
					+ userName + "]";
		}
		
}

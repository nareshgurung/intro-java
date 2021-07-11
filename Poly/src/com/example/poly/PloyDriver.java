package com.example.poly;

public class PloyDriver {
	public static void main(String[] args) {
		Overriding or1 = new Overriding();
		//Upcasting
		Parent p1 = new Overriding();
		Parent p2 = new Parent();
		
		System.out.println("Overridding x variable:"+ or1.x);
		System.out.println(or1.getObj());
		
		System.out.println("Parent x variable:" + p1.x);
		System.out.println("Parent x variable:" + p2.x);
		
		System.out.println("Overriding x variable: " + ((Overriding)p1).x);
		
//		System.out.println("Overriding getObj(): " + or1.getObj());
//		System.out.println("Overriding getObj(): " + p1.getObj());
		
		System.out.println("....");
		System.out.println("Parent getObj(): " + p2.getObj());
	
		System.out.println("Overriding static method: " + or1.hiding());
		System.out.println("Parent static method: " + p1.hiding());
		System.out.println("Parent static method: " + p2.hiding());
		System.out.println("Overriding static method: " + (((Overriding)p1).hiding()));

		final String i = "inherited boolean: ";
		System.out.println(i + or1.inherited);
		System.out.println(i + p1.inherited);
		System.out.println(i + p2.inherited);
	}
}
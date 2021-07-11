package com.example.generics;

public class Generics {

	public static void main(String[] args) {
		
		// we can create an instance of our generic class like this
		GenericClass<Integer> gc  = new GenericClass<Integer>(5);
		
		// what we can't do is somenthing like this. 
//		GenericClass<String> gc2 = new GenericClass<String>(3);
		
		System.out.println(gc.getValue());
		
		// we must only input integers now
		VeryGeneric<String> vg = new VeryGeneric<String>("hello");
		VeryGeneric<Double> vg2 = new VeryGeneric<Double>(4.5);
		
		System.out.println(vg.value);
		System.out.println(vg2.value);
		
		//we still cant achange the type of value 
		// vg2.value = "Hello"
	}
}
class GenericClass<T extends Number>{
	private T value;
	private double value2;
	
	public GenericClass(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
class VeryGeneric<T>{
	public T value;
	public VeryGeneric(T value) {
		this.value = value;
	}
}

package com.example.factory;

public class FactoryDriver {

	public static void main(String[] args) {

		String country;
		country = "USA";
		Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA Currency: " + usa.getSymbol());
	}

}

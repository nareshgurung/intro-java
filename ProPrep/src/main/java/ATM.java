import java.util.Scanner;

public class ATM {
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////
	//init Bank
	Bank theBank = new Bank("Bank of Shine");
	
	// add a user, which also creates a saving account
//	User aUser = theBank.addUser("john", "white", "1234");
	
	User curUser;
	while(true) {
		Employee emp;
		System.out.println("Please tell us Whow are you (Customer/Employee): ");
		String differ = sc.nextLine();
		if(differ.equalsIgnoreCase("customer")) {
		//stay in the login prompt until successful login
		curUser = mainMenuPrompt(theBank, sc);
		//stay in main menu until user quits
		printUserMenu(curUser, sc);
	}else if(differ.equalsIgnoreCase("employee")) {
		System.out.println("press 1 for sign up, 2 for login");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.print("Please enter your firstNname: ");
			String efirstname = sc.nextLine();
			System.out.print("Please enter your lastName: ");
			String elastname = sc.nextLine();
			System.out.println("Please enter you password");
			String epassword = sc.nextLine();
			try {
				emp =theBank.addEmployee(efirstname, elastname, epassword); // need to add employee in the bank
				System.out.println("Welcome to you " + theBank);
			} catch(Exception e) {
				System.out.println("Username or password was incorect. Goodbye");
			}
		case 2:
			System.out.println("Please enter your employee Id: ");
			String eId = sc.nextLine();
			System.out.println("Please enter your password: ");
			String ePass = sc.nextLine();
			emp = theBank.employeeLogin(eId, ePass);  //need to create employee login in bank
			if(emp == null) {
				System.out.println("Incorrect user ID/pin combination. Please try again. ");
			}
			break;
		}
	}
  }
		
}

public static User mainMenuPrompt(Bank theBank, Scanner sc) {
	
	//inits
	
	String userID;
	String pin;
	User authUser = null;
	/////////////////////////////////////////////////
	do {
	System.out.println("Login or Signup? Press 1 to signup, Press 2 to Sigin");
	int choice = Integer.parseInt(sc.nextLine());
	switch(choice) {
	case 1: 
			System.out.print("Please enter your firstNname: ");
			String firstname = sc.nextLine();
			System.out.print("Please enter your lastName: ");
			String lastname = sc.nextLine();
			System.out.println("Please enter you password");
			String password = sc.nextLine();
		///////////////////////////////////////////////////
			try {
				authUser =theBank.addUser(firstname, lastname, password);
				System.out.println("Welcome to you " + theBank);
			} catch(Exception e) {
				System.out.println("Username or password was incorect. Goodbye");
			}
		break;
	//prompt the user for user ID/pin combo until a correct one is reached
		case 2:
			System.out.print("welcome\n");
			System.out.println("Enter user UserName: ");
			userID = sc.nextLine();
			System.out.println("enter password:");
			pin = sc.nextLine();
			
			//try to get the user object corresponding to the ID and pin combo
			authUser = theBank.userLogin(userID,  pin);
			if(authUser == null) {
				System.out.println("Incorrect user ID/pin combination. Please try again. ");
			}
			break;
	}
}while(authUser == null); //continue looping until successful login
	return authUser;
}
	

public static void printUserMenu(User theUser, Scanner sc) {
	
	//print a summary of the user's accounts
	theUser.printAccountsSummary();
	//init
	int choice;
	//user menu 
	do {
		System.out.println("Welcome " + theUser.getFirstName() + ", What would you like to do \n");
		System.out.println("  1) Show account transaction history");
		System.out.println("  2) withdrawl");
		System.out.println("  3) deposit");
		System.out.println("  4) Transfer");
		System.out.println("  5) Quit");
		System.out.println();
		System.out.println("enter choice: ");
		choice = sc.nextInt();
		
		if(choice<1 || choice>5) {
			System.out.println("Invalie choice. plase choose 1-5");
		}
		
	}while(choice<1 || choice>5);
	
	switch(choice) {
	case 1:
		ATM.showTransHistory(theUser, sc);
		break;
	case 2:
		ATM.withdrawFunds(theUser, sc);
		break;
	case 3:
		ATM.depositFunds(theUser, sc);
		break;
	case 4:
		ATM.transferFunds(theUser, sc);
	}
	//redisplay this menu unless the user wants to quit
	if(choice != 5) {
		ATM.printUserMenu(theUser,  sc);
		
	}else {
		System.out.print("Thank you for being a valued Customer.");
		System.exit(1);
	}
	}
public static void showTransHistory(User theUser, Scanner sc) {
	int theAcct;
	
	//get account whose transaction history to look at
	do {
		System.out.println("Enter the number (1-2) fo the account whose transactions\n "
				+ "you want to see: ");
		theAcct = sc.nextInt()-1;
		if(theAcct<0 || theAcct>= theUser.numAccounts()) {
			System.out.println("invalid account plaeas ty again");
		}
	}while(theAcct<0 || theAcct>= theUser.numAccounts());
	
	//print the transaction history
	theUser.printAcctTransHistory(theAcct);
}

public static void transferFunds(User theUser, Scanner sc) {
	
	//inits
	int fromAcct;
	int toAcct;
	double amount;
	double acctBal;
	
	//get the account to transfer from 
	do {
		System.out.printf("enter the number (1-2) of the account\n"
				+ "to transfer from: ", theUser.numAccounts());
		fromAcct = sc.nextInt()-1;
		if(fromAcct <0 || fromAcct >= theUser.numAccounts()) {
			System.out.println("Invalid account. Please try again. ");
		}
	}while(fromAcct <0 || fromAcct >= theUser.numAccounts());
	acctBal = theUser.getAcctBalance(fromAcct);
	
	// get the account to transfer to 
	do {
		System.out.print("enter the number(1-2) of the account\n"
				+ "to transfer to: ");
		toAcct = sc.nextInt()-1;
		if(toAcct <0 || toAcct >= theUser.numAccounts()) {
			System.out.println("Invalid account. Please try again. ");
		}
	}while(toAcct <0 || toAcct >= theUser.numAccounts());
	
	// get the amount to transer 
	do {
		System.out.print("Enter the amount to transfer: $");
		amount = sc.nextDouble();
		if(amount <0) {
			System.out.println("amount must be greater than zero");
		}else if(amount> acctBal) {
			System.out.println("Amount must not be greater than balance");
		}
	}while(amount<0 || amount> acctBal);
	//finally, do the transfer
	theUser.addAcctTransaction(fromAcct, -1*amount, String.format("Transfer to account %s", theUser.getAcctUUID(toAcct)));
	// adding money to acct
	theUser.addAcctTransaction(toAcct, amount, String.format("Transfer to account %s", theUser.getAcctUUID(fromAcct)));
	
}
public static  void withdrawFunds(User theUser, Scanner sc) {
	//inits
		int fromAcct;
		double amount;
		double acctBal;
		String memo;
		
		//get the account to transfer from 
		do {
			System.out.printf("enter the number(1-2) of the account\n"
					+ "Withdraw from: ", theUser.numAccounts());
			fromAcct = sc.nextInt()-1;
			if(fromAcct <0 || fromAcct >= theUser.numAccounts()) {
				System.out.println("Invalid account. Please try again. ");
			}
		}while(fromAcct <0 || fromAcct >= theUser.numAccounts());
		acctBal = theUser.getAcctBalance(fromAcct);
		
		do {
			System.out.print("Enter the amount to withdraw: $");
			amount = sc.nextDouble();
			if(amount <0) {
				System.out.println("amount must be greater than zero");
			}else if(amount> acctBal) {
				System.out.println("Amount must not be greater than balance" );
			}
		}while(amount<0 || amount> acctBal);
		
		//gobble up rest of previous input
		sc.nextLine();
		
		//geta memo
		System.out.println();
		System.out.println("Enter a memo: ");
		memo = sc.nextLine();
		//do the withdrawl
		theUser.addAcctTransaction(fromAcct, -1*amount, memo);	
		
		
}

	public static void depositFunds(User theUser, Scanner sc) {
		int toAcct;
		double amount;
		double acctBal;
		String memo;
//get the account to transfert from 
			do {
				System.out.println("enter the number (1-2) of the account\n"
						+ "Account to Deposit : ");
				toAcct = sc.nextInt()-1;
				if(toAcct<0 || toAcct>= theUser.numAccounts()) {
					System.out.println("Invalid account. Please try again. ");
				}
			}while(toAcct<0 || toAcct>= theUser.numAccounts());
			acctBal = theUser.getAcctBalance(toAcct);
					
			do {
				System.out.println("Enter the amount to Deposit: ");
				amount = sc.nextDouble();
				if(amount <0) {
					System.out.println("amount must be greater than zero");
				}
			}while(amount<0);
			
			sc.nextLine();
			
			//geta memo
			System.out.println("Enter a Post: ");
			memo = sc.nextLine();
			//do the withdrawl
			theUser.addAcctTransaction(toAcct, amount, memo);	
	
}	
}

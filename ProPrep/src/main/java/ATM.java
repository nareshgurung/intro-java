import java.util.Scanner;

public class ATM {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	//init Bank
	Bank theBank = new Bank("Bank of Shine");
	
	// add a user, which also creates a saving account
	User aUser = theBank.addUser("John", "Doe", "1234");
	
	// add a checking account 
	Account newAccount = new Account("Checking", aUser, theBank);
	aUser.addAccount(newAccount);
	theBank.AddAccount(newAccount);
	
	User curUser;
	while(true) {
		//stay in the login prompt until successful login
		curUser = ATM.mainMenuPrompt(theBank, sc);
		
		//stay in main menu until user quits
		ATM.printUserMenu(curUser, sc);
	}
}

public static User mainMenuPrompt(Bank theBank, Scanner sc) {
	
	//inits
	String userID;
	String pin;
	User authUser;
	
	//prompt the user for user ID/pin combo until a correct one is reached
		do {
			System.out.printf("welcome\n", theBank.getName());
			System.out.println("Enter user ID: ");
			userID = sc.nextLine();
			System.out.println("enter pin:");
			pin = sc.nextLine();
			
			//try to get the user object corresponding to the ID and pin combo
			authUser = theBank.userLogin(userID,  pin);
			if(authUser == null) {
				System.out.println("Incorrect user ID/pin combination. "+ "Please try again. ");
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
		System.out.printf("Welcome %s, what would you like to do \n", theUser.getFirstName());
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
		System.out.printf("Enter the number (1-%d) fo the account whose transactions\n "
				+ "you want to see: ", theUser.numAccounts());
		theAcct = sc.nextInt() -1;
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
		System.out.printf("enter the number (1-%d) of the account\n"
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
		System.out.printf("Enter the amount to transfer(max $%.02f): $", acctBal);
		amount = sc.nextDouble();
		if(amount <0) {
			System.out.println("amount must be greater than zero");
		}else if(amount> acctBal) {
			System.out.printf("Amount must not be greater than balance \n"
					+ "balance of $%.2f.\n", acctBal);
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
			System.out.printf("enter the number(1-%d) of the account\n"
					+ "Withdraw from: ", theUser.numAccounts());
			fromAcct = sc.nextInt()-1;
			if(fromAcct <0 || fromAcct >= theUser.numAccounts()) {
				System.out.println("Invalid account. Please try again. ");
			}
		}while(fromAcct <0 || fromAcct >= theUser.numAccounts());
		acctBal = theUser.getAcctBalance(fromAcct);
		
		do {
			System.out.printf("Enter the amount to withdraw (max $%.02f): $", acctBal);
			amount = sc.nextDouble();
			if(amount <0) {
				System.out.println("amount must be greater than zero");
			}else if(amount> acctBal) {
				System.out.printf("Amount must not be greater than balance \n"
						+ "balance of $%.2f.\n", acctBal);
			}
		}while(amount<0 || amount> acctBal);
		
		//gobble up rest of previous input
		sc.nextLine();
		
		//geta memo
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
				System.out.printf("enter the number (1-%d) of the account\n"
						+ "Account to Deposit : ", theUser.numAccounts());
				toAcct = sc.nextInt()-1;
				if(toAcct<0 || toAcct>= theUser.numAccounts()) {
					System.out.println("Invalud account. Please try again. ");
				}
			}while(toAcct<0 || toAcct>= theUser.numAccounts());
			acctBal = theUser.getAcctBalance(toAcct);
					
			do {
				System.out.printf("Enter the amount to Deposit(max $%.02f): $", acctBal);
				amount = sc.nextDouble();
				if(amount <0) {
					System.out.println("amount must be greater than zero");
				}
			}while(amount<0);
			
			sc.nextLine();
			
			//geta memo
			System.out.println("Enter a memo: ");
			memo = sc.nextLine();
			//do the withdrawl
			theUser.addAcctTransaction(toAcct, amount, memo);	
	
}	
}

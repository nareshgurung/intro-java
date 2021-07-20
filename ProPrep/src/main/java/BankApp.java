import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoDB;
import com.bank.dao.EmployeeDao;
import com.bank.dao.EmployeeDaoDB;
import com.bank.dao.UserDao;
import com.bank.dao.UserDaoDB;
import com.bank.model.Account;
import com.bank.model.AccountService;
import com.bank.model.Employee;
import com.bank.model.EmployeeService;
import com.bank.model.UserService;
import com.bank.model.Transaction;
import com.bank.model.User;

public class BankApp {
	
	private static UserDao uDao  = new UserDaoDB();
	private static EmployeeDao eDao =new EmployeeDaoDB();
	private static AccountDao aDao = new AccountDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static EmployeeService eServ = new EmployeeService(eDao);
	private static AccountService aServ = new AccountService(aDao);
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////
	//init Bank
//	System.out.println(u.getAllUsers());
//	System.out.println(u.getUserByUsername("david243"));
//System.out.println(theBank.addUser("naresh", "gurung", "password"));
//	System.out.println(theBank.userLogin("david243", "password"));
	// add a user, which also creates a saving account
//	User aUser = theBank.addUser("john", "white", "1234");
	User curUser = null;
	Employee employee = null;
	Account account = null;
	while(true) {
		System.out.println("Please tell us Who are you (Customer/Employee): ");
		String differ = sc.nextLine();
		if(differ.equalsIgnoreCase("customer")) {
		//stay in the login prompt until successful login
		curUser = mainMenuPrompt(curUser, sc);
		//stay in main menu until user quits
		//printUserMenu(curUser, theBanking, sc);
		/////////////////////////////////////////////////////////
		System.out.println("checking Account no:" + curUser.getCheckingAccount());
		System.out.println("saving Account no:" + curUser.getSavingAccount());
		int choice;
		//user menu 
		do {
			System.out.println("Welcome " + curUser.getFirstName() + ", What would you like to do \n");
			System.out.println("  1)deposit ");
			System.out.println("  2) withdrawl");
			System.out.println("  3) Show account transaction history");
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
			BankApp.deposit(account, sc);
			break;
		case 2:
			BankApp.withdrawFunds(account, sc);
			break;
		case 4:
			BankApp.transferFunds(account, sc);
			break;
		case 3:
			BankApp.viewAccount(account, sc);
			break;
//		}
//		//redisplay this menu unless the user wants to quit
//		if(choice != 5) {
//			BankApp.printUserMenu(theUser, theBank, sc);
			
//		}else {
//			System.out.print("Thank you for being a valued Customer.");
//			System.exit(1);
		}
		
		/////////////////////////////////////////////////////////////
		///////////////////////////////////////
	}else if(differ.equalsIgnoreCase("employee")) {
		System.out.println("press 1 for sign up, 2 for login");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Please enter your firstNname: ");
			sc.nextLine();
			String efirstname = sc.nextLine();
			System.out.println("Please enter your lastName: ");
			String elastname = sc.nextLine();
			System.out.println("Please enter you password");
			String epassword = sc.nextLine();
			try {
				employee =eServ.addEmployee(efirstname, elastname, epassword); // need to add employee in the bank
				System.out.println("Welcome to you ");
				System.out.println(employee);
			} catch(Exception e) {
				System.out.println("Username or password was incorect. Goodbye");
			}
			break;
		case 2:
			System.out.println("Please enter your employee username: ");
			sc.nextLine();
			String eId = sc.nextLine();
			System.out.println("Please enter your password: ");
			String ePass = sc.nextLine();
				employee = eServ.employeeLogin(eId, ePass);  //need to create employee login in bank
				System.out.println(employee);
				printEmployeeMenu(employee, sc);
			break;
		}
//		printEmployeeMenu(emp, sc);
	}
	
  }
		
}
public static void deposit(Account acct, Scanner sc) {
	Account account = null;
	sc.nextLine();
	System.out.println("Enter the account ID: ");
	int usr = sc.nextInt();
	System.out.println(usr);
	System.out.println("Enter the deposit Amount: ");
	int amount = sc.nextInt();
	try {
		account = aServ.addDeposit(usr, amount);
//		System.out.println(account);
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public static void viewAccount(Account accounts, Scanner sc) {
	Account act;
		System.out.println("Please enter the account Number: ");
		int aNumber = sc.nextInt();
		try {
			act = aServ.viewAccount(aNumber);
		}catch(Exception e) {
			System.out.println("invalid accountNumber");
			e.printStackTrace();
		}
//		String acct = Integer.toString(sc.nextInt());
//		if(acct.equals(account.getUUID())) {
//			users.printAccountsSummary();
//			users.printAcctTransHistory(Integer.parseInt(acct));
//			}else{
		}

public static void transferFunds(Account accounts, Scanner sc) {
	Account act;
	System.out.println("Please enter account number trans from: ");
	int numf = sc.nextInt();
	System.out.println("Please enter the account number trans to: ");
	int numt = sc.nextInt();
	System.out.println("Please enter the amount");
	int amt = sc.nextInt();
	act = aServ.transferAmount(numf, numt, amt);
}
public static void withdrawFunds(Account accounts, Scanner sc) {
	
	Account act;
	System.out.println("Please enter the account number: ");
	int num = sc.nextInt();
	System.out.println("Please enter the amount: ");
	int amt = sc.nextInt();
	
	act = aServ.withdrawAmount(num, amt);
	
	
}
public static User mainMenuPrompt(User users, Scanner sc) {
	
	//inits
	
	String userID;
	String pin;
	User authUser = null;
	/////////////////////////////////////////////////
	do {
	System.out.println("Login or Signup? Press 1 to signup as customer, Press 2 to Sigin");
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
				authUser =uServ.addUser(firstname, lastname, password);
				System.out.println(authUser);
				System.out.println("Welcome to you " );
			} catch(Exception e) {
				System.out.println("you are not able to singUp. Goodbye");
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
			try {
				authUser = uServ.userLogin(userID,  pin);
//				System.out.println("you are logged in ");
			}catch(Exception e) {		
				System.out.println("Incorrect user ID/pin combination. Please try again. ");
			}
			break;
	}


}while(authUser == null); //continue looping until successful login
	return authUser;
}
	///////////////////////////////// leave here. 
	public static void printEmployeeMenu(Employee emp, Scanner sc) {
		
		//print a summary of the user's accounts
//		theUser.printAccountsSummary();
		//init
		int choice;
		Account account = null;
		UserService theBank = null;
		User users = null;
		//employee menu 
		do {
			System.out.println("Welcome " + emp.getFirstName() + ", What would you like to do \n");
			System.out.println("  1) Reject Account and approve user's account");
			System.out.println("  2) transfer fund user's fund");
			System.out.println("  3) view account user's account");
			System.out.println("  4) Quit");
			System.out.println();
			System.out.println("enter choice: ");
			choice = sc.nextInt();
			
			if(choice<1 || choice>5) {
				System.out.println("Invalid choice. plase choose 1-5");
			}
			

			switch(choice) {
			case 1:
				BankApp.rijectAcctandApprove();
				break;
			case 2:
				BankApp.transferFund();
				break;
//			case 3:
//				BankApp.viewAccount();
//				break;
			}
		
		}while(choice<1 || choice>5);
			//redisplay this menu unless the user wants to quit
	/*	if(choice != 4) {
			BankApp.printEmployeeMenu(emp,  sc);
			
		}else {
			System.out.print("Thank you for being a valued Customer.");
			System.exit(1);
		}*/
	}
	public static void rijectAcctandApprove() {

		Scanner sc=new Scanner(System.in);
//		//Employee empusr;
//				User usr;
				Account acc;
		System.out.println("Enter your SSN: ");
//		int ssn[8] = sc.nextInt();
//		if(ssn == ssn [8])
//		{
//			System.out.print("Enter userid ");
//			int id=sc.nextInt();
//			System.out.println("Enter the user's firstname: ");
//			String first = sc.nextLine();
//			System.out.println("Enter the user's lastName: "); 
//			String last =sc.nextLine(); 
//			System.out.println("Enter the user's username:"); 
//			String user = sc.nextLine();
//			System.out.println("Enter the user's password:"); 
//			String pwd = sc.nextLine();
		
//			usr=new User(id,first,last,pwd);
//			acc=new Account(id);
//		}
//		else
//			System.out.println("Account Creation Rejected as no SSN! ");
//
//				
//					usr = eServ.deleteUser(first, last, user);
//						System.out.println("You entered invalid usename try again");
////				
	}

	
private static void transferFund() {
		// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	Account accounts;
	System.out.print("Enter user's Account Number to transfer from: ");
	int act=sc.nextInt();
	System.out.println("Enter user's account number to transfer to: ");
	int act1 = sc.nextInt();
	System.out.println("Enter the amount: ");
	int amt = sc.nextInt();
	try {
		accounts = aServ.transferAmount(act, act1, amt);
		System.out.println("your amount has been transfered. ");
	}catch(Exception e) {
		e.printStackTrace();
		
	}
	}
}



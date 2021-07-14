
import java.util.ArrayList;
import java.util.Random;

public class Bank {
	
	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	
	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
		this.employees = new ArrayList<Employee>();
	}

	
	// account uuid
	public String getNewAccountUUID() {
			//inits
			String uuid;
			Random rng = new Random();
			int len = 10;
			boolean nonUnique;
					
			
			do {
				uuid = "";
				for(int c= 0; c<len; c++) {
					uuid +=((Integer)rng.nextInt(10)).toString();
				}
				// check to make sure it's unique
				nonUnique = false;
				for(Account a : this.accounts) {
					if(uuid.compareTo(a.getUUID())==0) {
						nonUnique = true;
						break;
					}
				}
				
			}while(nonUnique);
			
			return uuid;
			
		}
	public void AddAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	public User addUser(String firstName, String lastName, String password) {
		//create a new User object and add it to our list
		User newUser = new User(firstName, lastName, password, this);
		this.users.add(newUser);
		
		//create a saving account for the user and add to User and Bank accounts lists
		Account newAccount = new Account("Saving", newUser, this);
		Account newAccount1 = new Account("checking", newUser, this);

				
		// add to holder and bank lists
		newUser.addAccount(newAccount);
		this.accounts.add(newAccount);
		newUser.addAccount(newAccount1);
		this.accounts.add(newAccount1);
		
		
		return newUser;
	}
	/////////////////////////////////////////////////////////////////////
//	public Employee addUser(String Name, String pin) {
//		//create a new User object and add it to our list
//		Employee newUser = new Employee(Name, pin);
//		this.employees.add(newUser);
//		
//		//create a saving account for the user and add to User and Bank accounts lists
//		Account newAccount = new Account("Saving", newUser, this);
//				
//		// add to holder and bank lists
//		newUser.addAccount(newAccount);
//		this.accounts.add(newAccount);
//		
//		return newUser;
//	}
	///////////////////////////////////////////////////////////////////////////////
//	public User signUP(String fristname, String lastname, String password) {
//		User u = new User(fristname, lastname, password);
//		users.add(u);
//		return u;
//
//	}
	public User userLogin(String userID, String password) {
		//search through list of users
		for(User u: this.users) {
			//check user ID is correct
			if(u.getUserName().equals(userID)) {
				if(u.getPassword().equals(password)) {
					System.out.println("Welcome ");
				return u;
				}else {
					System.out.println("Invalid credentials");
				}
			}
			System.out.println("user tried logging in that does not exist");
		}
		//if we havn't found the user or hava an incorect
		return null;
	}

	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Bank of Shine";
	}

}

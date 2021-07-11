
import java.util.ArrayList;
import java.util.Random;
public class Bank {
	
	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	
	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
	}

	//generate userid
	public String getNewUserUUID() {
		//inits
		String uuid;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;
		
		//continue looping until we get a unique id
		do {
			
			uuid = "";
			for(int c= 0; c<len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			// check to make sure it's unique
			nonUnique = false;
			for(User u : this.users) {
				if(uuid.compareTo(u.getUUID())==0) {
					nonUnique = true;
					break;
				}
			}
			
		}while(nonUnique);
		
		return uuid;
		
		
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
					uuid += ((Integer)rng.nextInt(10)).toString();
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
	
	public User addUser(String firstName, String lastName, String pin) {
		//create a new User object and add it to our list
		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);
		
		//create a saving account for the user and add to User and Bank accounts lists
		Account newAccount = new Account("Saving", newUser, this);
				
		// add to holder and bank lists
		newUser.addAccount(newAccount);
		this.accounts.add(newAccount);
		
		return newUser;
	}
	
	
	public User userLogin(String userID, String pin) {
		//search through list of users
		for(User u: this.users) {
			//check user ID is correct
			if(u.getUUID().compareTo(userID)== 0 && u.validatePin(pin) ) {
				return u;
			}
		}
		//if we havn't found the user or hava an incorect. 
		return null;
	}

	public String getName() {
		return name;
	}

}

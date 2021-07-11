import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class User {
	private String firstName;
	private String lastName;
	private String uuid;
	private byte pinHash[];
	
	private ArrayList<Account> accounts;
	
	public User(String firstName, String lastName, String pin, Bank theBank) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		// store the pin hash md5
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());			
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught no suchalogrithm");
			e.printStackTrace();
			System.exit(1);
		}

//		this.uuid = firstName + lastName + (new Random().nextInt(9000)+ 1000);
		this.uuid = theBank.getNewUserUUID();
		
		//reate empty list of accounts
		this.accounts = new ArrayList<Account>();
		//PRINT LOG MESSAGE
		System.out.println(("New user "+ lastName+ ", " + firstName + "with ID- " + this.uuid ));
	}
	
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	public String getUUID() {
		return this.uuid;
	}
	
	//validate pin method. 
	public boolean validatePin(String aPin) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), 
					this.pinHash);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught no suchalogrithm");
			e.printStackTrace();
			System.exit(1);
		}
		
		return false;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public void printAccountsSummary() {
		System.out.printf("\n\n%s's accounts summary\n", this.firstName);
		for(int a =0; a<this.accounts.size(); a++) {
			System.out.printf("%d) %s\n", a+1, this.accounts.get(a).getSummaryLine());
		}
		System.out.println();
	}
	public int numAccounts() {
		return this.accounts.size();
	}
	public void printAcctTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();
	}
	public double getAcctBalance(int fromAcct) {
		return this.accounts.get(fromAcct).getBalance();
	}
	public String getAcctUUID(int acctIdx) {
		return this.accounts.get(acctIdx).getUUID();
	}
	
	public void addAcctTransaction(int acctIdx, double amount, String memo) {
		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}
}

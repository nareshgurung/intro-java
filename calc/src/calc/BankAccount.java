package calc;

import java.util.Scanner;

public class BankAccount {
	{
		   // Creates Scanner class object
		   static Scanner sc = new Scanner(System.in);
		   // Defines maximum number of accounts allowed
		   static final int MAX_NUM = 100;

		   // Method to accept account information
		   public static int readAccounts(int []acctNum, String name[], double []balance)
		   {
		       // Scanner class object declared to read file contents
		       Scanner fileRead = null;
		       int recordIndex = 0;
		       // try block begins
		       try
		       {
		           // Opens the file for reading
		           fileRead = new Scanner(new File("BankingRecordSystemApplication.txt"));
		                  
		           // Loops till end of the file
		           while(fileRead.hasNext())
		           {
		               // Reads account number from file
		               acctNum[recordIndex] = fileRead.nextInt();
		               // Reads the name from the file
		               name[recordIndex] = fileRead.next();
		               // Reads the initial balance from the file
		               balance[recordIndex] = fileRead.nextDouble();
		               // Increase the record index by one
		               recordIndex++;
		           }// End of while loop
		          
		           // Displays number of records read from file
		           System.out.print("\n Successfully loaded " + recordIndex +
		                   " records from file.");      
		           // Close the file
		           fileRead.close();
		       }// End of try
		              
		       // Catch block to handle FileNotFoundException
		       catch (FileNotFoundException e)
		       {
		           e.printStackTrace();
		           System.err.println("Unable to open the file: BankingRecordSystemApplication.txt");
		       }// End of catch
		      
		       // Returns number of records
		       return recordIndex;
		   }// End of method
		  
		   /* Method to search an account number
		   * If found returns the found index position.
		   * Otherwise returns -1
		   */
		   public static int findAcct(int []acctNum, int maxAccts, int account)
		   {
		       // Loops till number of accounts
		       for(int index = 0; index < maxAccts; index++)
		           // Checks if current index position account number is same as parameter account number
		           if(acctNum[index] == account)
		               // Returns the found index
		               return index;
		       // Otherwise returns -1 for not found
		       return -1;
		   }// End of method
		  
		   // Method to withdraw amount from an account
		   public static void withdraw(int []acctNum, String name[], double []balance,
		           int maxAccts)
		   {
		       // Accepts account number
		       System.out.print("\n Enter the account number to withdraw: ");
		       int account = sc.nextInt();
		      
		       // Calls the method to search account and stores found status
		       int found = findAcct(acctNum, maxAccts, account);
		      
		       // Checks if found status is -1 display error message
		       if(found == -1)
		           System.out.print("\n ERROR: No such account number found " + account);

		       // Otherwise account number found
		       else
		       {
		           // Accept withdrawal amount
		           System.out.print("\n Enter the withdrawal amount $");
		           double amt = sc.nextDouble();
		          
		           // Checks if found record balance is greater than or equals to entered withdrawal amount
		           if(balance[found] >= amt)
		           {
		               // Update the balance
		               balance[found] -= amt;
		               // Display success message
		               System.out.print("\n Withdrawal Successful.");
		           }// End of if condition
		          
		           // Otherwise display error message for insufficient balance
		           else
		               System.out.print("\n ERROR: Insufficient balance. \n Current balance: $" + balance[found]);
		       }// End of else
		   }// End of method
		  
		   // Method to deposit amount to an account
		   public static void deposit(int []acctNum, double []balance, int maxAccts)
		   {
		       // Accepts account number
		       System.out.print("\n Enter the account number to deposit: ");
		       int account = sc.nextInt();
		      
		       // Calls the method to search account and stores found status
		       int found = findAcct(acctNum, maxAccts, account);
		      
		       // Checks if found status is -1 display error message
		       if(found == -1)
		           System.out.print("\n ERROR: No such account number found " + account);
		      
		       // Otherwise account number found
		       else
		       {
		           // Accept deposit amount
		           System.out.print("\n Enter the deposit amount $");
		           double amt = sc.nextDouble();
		          
		           // Checks if deposit amount is not negative
		           if(amt > 0)
		           {
		               // Update the balance
		               balance[found] += amt;
		               // Display success message
		               System.out.print("\n Deposit Successful.");
		           }// End of if condition

		           // Otherwise display error message
		           else
		               System.out.print("\n ERROR: Invalid deposit amount.");
		       }// End of else
		   }// End of method
		  
		   // Method to add a new account
		   public static int addAcct(int []acctNum, String name[], double []balance,
		           int maxAccts)
		   {
		       // Checks if current number of accounts is less than the maximum limit account
		       if(maxAccts < MAX_NUM)
		       {
		           // Accepts account number
		           System.out.print("\n Enter the account number to add: ");
		           int account = sc.nextInt();
		          
		           // Calls the method to search account and stores found status
		           int found = findAcct(acctNum, maxAccts, account);
		          
		           // Checks if found status is -1 then record not found add the account
		           if(found == -1)
		           {
		               // Assigns the account number
		               acctNum[maxAccts] = account;
		               System.out.print("\n Enter the Account Holder Name: ");
		               name[maxAccts] = sc.next();
		               System.out.print("\n Enter Account Initial Balance: $");
		               // Initializes balance to 0
		               balance[maxAccts] = sc.nextDouble();
		               // Increase the number of records by one
		               maxAccts++;
		               // Display success message
		               System.out.print("\n Accont " + account + " added successfully.");
		           }// End of if inner condition

		           // Otherwise account number found display error message for duplicate account
		           else
		               System.out.print("\n ERROR: Acount " + account + " already exits.");
		       }// End of outer if condition
		      
		       // Otherwise display error message
		       else
		           System.out.print("\n ERROR: Reached maximum limit.");
		      
		       // Returns current number of records
		       return maxAccts;
		   }// End of method
		  
		   // Method to display current balance of an account
		   public static void balance(int []acctNum, String name[], double []balance, int maxAccts)
		   {
		       // Accepts account number
		       System.out.print("\n Enter the account number to check balance: ");
		       int account = sc.nextInt();
		      
		       // Calls the method to search account and stores found status
		       int found = findAcct(acctNum, maxAccts, account);
		      
		       // Checks if found status is -1 display error message
		       if(found == -1)
		           System.out.print("\n ERROR: No such account number found " + account);

		       // Otherwise account number found display balance
		       else
		           System.out.print("\n Account Number: " + account + "\n Balance: $" + balance[found]);
		   }// End of method
		  
		   // Method to display all accounts information
		   public static void printAccts(int []acctNum, String name[], double []balance, int maxAccts)
		   {
		       // Loops till number of accounts
		       for(int index = 0; index < maxAccts; index++)
		           // Displays each account information
		           System.out.print("\n Account Number: " + acctNum[index] + "\n Balance: $" + balance[index]);
		   }// End of method
		  
		   // Method to delete an account
		   public static int deleteAcct(int []acctNum, String name[], double []balance,
		           int maxAccts)
		   {
		       // Accepts account number
		       System.out.print("\n Enter the account number to delete: ");
		       int account = sc.nextInt();
		      
		       // Calls the method to search account and stores found status
		       int found = findAcct(acctNum, maxAccts, account);
		      
		       // Checks if found status is -1 display error message
		       if(found == -1)
		           System.out.print("\n ERROR: No such account number found " + account);
		      
		       // Otherwise account number found
		       else
		       {
		           // Checks if found account balance is not zero then display error message
		           if(balance[found] != 0)
		               System.out.print("\n ERROR: Not a zero balance account. " +
		                       "\n Cannot delete account: " + account);

		           // Otherwise zero balance record
		           else
		           {
		               // Loops from found account number to end of the list
		               for(int index = found; index < maxAccts; index++)
		               {
		                   // Shifts account number to one position left
		                   acctNum[index] = acctNum[index + 1];
		                   // Shifts balance to one position left
		                   balance[index] = balance[index + 1];
		               }// End of for loop
		              
		               // Subtract number of accounts by one
		               maxAccts--;
		               // Display success message
		               System.out.print("\n Account number deleted." + account);
		           }// End of inner else
		       }// End of outer else
		      
		       // Returns current number of records
		       return maxAccts;
		   }// End of method
		  
		   // Method to write data to file
		   public static void writeAcct(int []acctNum, String name[], double []balance,
		           int maxAccts)
		   {
		       // PrintStream class object declared to write data to file
		       PrintStream printWrite = null;
		      
		       // try block begins
		       try
		       {
		           // Opens the file for writing
		           File fileWrite = new File("BankingRecordSystemApplication.txt");          
		           printWrite = new PrintStream(new BufferedOutputStream(
		                   new FileOutputStream(fileWrite)));
		          
		           // Loops till number of records available
		           for(int c = 0; c < maxAccts; c++)
		           {
		               // Checks if last record to write
		               if(c == maxAccts - 1)
		                   // Write the record without new line character
		                   printWrite.print(acctNum[c] + " " + name[c] + " " + balance[c]);
		              
		               // Otherwise not the last record
		               else
		                   // Write the record with new line character
		                   printWrite.println(acctNum[c] + name[c] + balance[c]);
		           }// End of for loop
		          
		           // Close the file
		           printWrite.close();
		       }// End of try
		              
		       // Catch block to handle FileNotFoundException
		       catch (FileNotFoundException e)
		       {
		           e.printStackTrace();
		           System.err.println("Unable to open the file");
		       }// End of catch
		   }// End of method
		  
		   // Method to update an account
		   public static void updateAcct(int []acctNum, String name[], double []balance,
		           int maxAccts)
		   {
		       // Accepts account number
		       System.out.print("\n Enter the account number to update: ");
		       int account = sc.nextInt();
		      
		       // Calls the method to search account and stores found status
		       int found = findAcct(acctNum, maxAccts, account);
		      
		       // Checks if found status is -1 display error message
		       if(found == -1)
		           System.out.print("\n ERROR: No such account number found " + account +
		                   " cannot update.");
		      
		       // Otherwise account number found
		       else
		       {
		           System.out.print("\n Enter Account Holder Name: ");
		           name[found] = sc.next();
		           System.out.print("\n Enter balance: $");
		           balance[found] = sc.nextDouble();
		           System.out.print("\n Account number " + account + " updated successfully.");
		       }// End of else
		   }// End of method
		  
		   // Method to display all accounts
		   public static void showAllAccounts(int []acctNum, String name[], double []balance,
		               int maxAccts)
		   {
		       System.out.println("\n\n *********** Account Information *********** ");
		       // Loops till number of records available
		       for(int c = 0; c < maxAccts; c++)
		           System.out.println("\n Account Number: " + acctNum[c] +
		                   "\n Account Holder Name: " + name[c] +
		                   "\n Current Balance: $" + balance[c]);
		   }// End of method
		}// End of class

		// Driver class definition
		public class BankingRecordSystemApplication
		{
		   // Method to display menu
		   public static void menu()
		   {
		       System.out.print("\n ****************** MENU ****************** ");
		       System.out.print("\n N - New Account.");
		       System.out.print("\n X - Delete Account.");
		       System.out.print("\n U - Update Account.");
		       System.out.print("\n S - Show All Accounts.");
		       System.out.print("\n W - Withdrawal.");
		       System.out.print("\n D - Deposit.");      
		       System.out.print("\n B - Balance.");
		       System.out.print("\n Q - Quit.");      
		       System.out.print("\n ***************************************** ");
		   }// End of method
		  
		   // main method definition
		   public static void main(String ss[])
		   {
		       // Creates an integer type array of size MAX_NUM to store account numbers
		       int [] acctNum = new int[BankAccount.MAX_NUM];
		       // Creates an string type array of size MAX_NUM to store account holder name
		       String [] name = new String[BankAccount.MAX_NUM];
		       // Creates an double type array of size MAX_NUM to store balance
		       double [] balance = new double[BankAccount.MAX_NUM];
		      
		       // Calls the method to create accounts and stores the number of
		       // account created
		       int records = BankAccount.readAccounts(acctNum, name, balance);
		          
		       // Loops till user choice is not 'Q' or 'q'
		       do
		       {
		           // Calls the method to display menu
		           menu();
		           // Accepts user choice
		           System.out.print("\n Enter your choice: ");
		           char ch = BankAccount.sc.next().charAt(0);
		              
		           // Checks user choice and calls appropriate method
		           switch(ch)
		           {
		               case 'W':
		               case 'w':
		                   BankAccount.withdraw(acctNum, name, balance, records);
		               break;
		               case 'D':
		               case 'd':
		                   BankAccount.deposit(acctNum, balance, records);
		               break;
		               case 'N':
		               case 'n':
		                   records = BankAccount.addAcct(acctNum, name, balance, records);
		               break;
		               case 'X':
		               case 'x':
		                   records = BankAccount.deleteAcct(acctNum, name, balance, records);
		               break;
		               case 'B':
		               case 'b':
		                   BankAccount.balance(acctNum, name, balance, records);
		               break;
		               case 'U':
		               case 'u':
		                   BankAccount.updateAcct(acctNum, name, balance, records);
		               break;
		               case 'S':
		               case 's':
		                   BankAccount.showAllAccounts(acctNum, name, balance, records);
		               break;
		               case 'Q':
		               case 'q':
		                   BankAccount.writeAcct(acctNum, name, balance, records);
		                   System.exit(0);
		               break;
		               default:
		                   System.out.println("ERROR: Invalid Choice! Try again.");
		           }// End of switch case
		       }while(true);// End of do - while loop      
		   }// End of main method
		}// E
}

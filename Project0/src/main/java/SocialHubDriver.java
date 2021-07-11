import java.util.List;
import java.util.Scanner;

import com.example.exceptions.InvalidCredentialsException;
import com.example.models.Account;
import com.example.models.Post;
import com.example.models.User;
import com.example.services.AccountService;
import com.example.services.PostService;
import com.example.services.UserService;

public class SocialHubDriver {
	
	private static UserService uServ = new UserService("users.txt");
	private static PostService pServ = new PostService("posts.txt");
	private static AccountService aServ = new AccountService("acct.txt");
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//This will be used to control our loop
		boolean done = false;
		
		User u = null;
		Integer b = 0;
		
				
		
		while(!done) {
			if(u == null) {
				System.out.println("Login or Signup? Press 1 to Login, Press 2 to Signup");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter your password: ");
					String password = in.nextLine();
					try {
						u = uServ.login(username, password);
						System.out.println("Welcome " + u.getFirstName());
					} catch(Exception e) {
						System.out.println("Username or password was incorect. Goodbye");
						done = true;
					}
					//print the instruction for transaction. 
					String menu = "1) view balance: \n"+
									"2) add balance: \n"+
							
									"3) withdraw amount";
					System.out.println(menu);
					System.out.println("Please enter the desired number: ");
					int tran = Integer.parseInt(in.nextLine());
					switch(tran) {
					case 1:
						List<Account> acct= aServ.getAllBalance();  
						System.out.println(acct);
					case 2:
						System.out.println("Enter the amout that you want to deposit: ");
						String inAmount = in.nextLine();
						Account a = new Account(inAmount);
						aServ.addBalance(a);
						System.out.println(inAmount);
					}

					
				} else {
					System.out.print("Please enter you first name: ");
					String first = in.nextLine();
					System.out.println("Please enter your last name: ");
					String last = in.nextLine();
					System.out.println("Please enter a password: ");
					String password = in.nextLine();
					
					try {
						u = uServ.signUp(first, last, password);
						System.out.println("You may now log in with the username: " + u.getUserName());
					} catch (Exception e) {
						System.out.println("Sorry, we could not process your request");
						System.out.println("Please try again later");
						done = true;
					}
				}
			} else {
				System.out.println("To view posts press 1, to create a post press 2");
				int choice = Integer.parseInt(in.nextLine());
				//If the user chooses 1, we will show them the list of posts
				if(choice == 1) {
					List<Post> posts = pServ.getAllPosts();
					for(Post post: posts) {
						System.out.println(post.getUser() + ":");
						System.out.println(post.getContent());
						System.out.println();
					}
					System.out.println("Are you finished? Press 1 for yes, press 2 for no");
					choice = Integer.parseInt(in.nextLine());
					done = (choice == 1) ? true : false;
				} else {
					System.out.println("Please enter your content below:");
					String content = in.nextLine();
					Post p = new Post(u.getUserName(), content);
					pServ.addPost(p);
					System.out.println("Post was received, are you finished? Press 1 for yes, press 2 for no");
					choice = Integer.parseInt(in.nextLine());
					done = (choice == 1) ? true : false;
				}
			}
		}
		
		System.out.println("Goodbye :)");
		in.close();
	}
	
}
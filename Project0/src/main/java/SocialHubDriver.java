import java.util.List;
import java.util.Scanner;

import com.example.models.Accounts;
import com.example.exceptions.InvalidCredentialsException;
import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;
import com.example.services.AccountService;
import com.example.services.PostService;
import com.example.services.UserService;
import com.example.dao.PostDao;
import com.example.dao.PostDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;


public class SocialHubDriver {
//	
//	private static UserService uServ = new UserService("users.txt");
//	private static PostService pServ = new PostService("posts.txt");
//	private static AccountService aServ = new AccountService("acct.txt");
//	
	private User uDao = new UserDaoDb();
	private PostDao pDao = new PostDaoDB();
	private static UserService uServ = new UserService();
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println(rick);
		pServ.addPost(rick.getId(), rick.getId(),"Morty and I just on a sick adventure");
		
		List<PostDisplay> pList = pServ.getAllPosts();
		
		for(int i= 0; i<pList.size(); i++) {
			System.out.println(pList.get(i).getUsername());
			System.out.println(pList.get(i).getContent());
			System.out.println();
		}
		rick = pServ.loadUserPosts(rick);
		
		System.out.println(rick);
//		System.out.println(pServ.getAllPosts());
		
//	while(true) { // not working, just taking a test
//		int count = 1;
//		String email = "rick" + count + "email.com";
//		uServ.signUp("Rick", "Sanchez", email, "password");
//		count++;
//	}
//   
	}
}
/* 7/15 4.10
		System.out.println(uDao.getAllUsers());
		
		System.out.println(uDao.getUserByUsername("larryking8345"));
		
		
		User u = uDao.getUserByUsername("RickSanchez4882");
		
		uDao.deleteUser(u);
		
		System.out.println(uDao.getAllUsers());
		
		PostDao pDao = new PostDaoDB();
		
		Post p = new Post(1, 1, "Hello to myself");
		
		pDao.createPost(p);
		
		System.out.println(pDao.getAllPosts());
		
		u = uDao.getUserByUsername("haydenfields3841");
		
		u = pDao.getUsersPosts(u);
		
		System.out.println(u);
		
		List<Post> postList = u.getPosts();
		
		for(int i=0; i<postList.size(); i++) {
			System.out.println(postList.get(i).getPostContent());
		}
		
//		Scanner sc = new Scanner(System.in);
//		UserDao uDao = new UserDaoDB();
//		System.out.println(uDao.getAllUsers());
//		System.out.println(uDao.getUserByUsername("larryking8345"));
//		
//		User u = new User("Rick", "Sanchez", "Rick@rickmail.com", "ilovemorty");
//		uDao.createUser(u);
//		System.out.println(uDao.getAllUsers());
//		
		
	}
}
		
		

		//This will be used to control our loop
		/*
	User u = null;
	Accounts a = null;
	boolean done = false;
		while(!done) {
			if(u == null) {
				System.out.println("Login or Signup? Press 1 to Login, Press 2 to Signup");
				int choice = Integer.parseInt(sc.nextLine());
				if(choice == 1) {
					System.out.print("Please enter your username: ");
					String username = sc.nextLine();
					System.out.print("Please enter your password: ");
					String password = sc.nextLine();
					try {
						u = uServ.login(username, password);
						System.out.println("Welcome " + u.getFirstName());
					} catch(Exception e) {
						System.out.println("Username or password was incorect. Goodbye");
						done = true;
					}
					
				} else {
					System.out.print("Please enter you first name: ");
					String first = sc.nextLine();
					System.out.println("Please enter your last name: ");
					String last = sc.nextLine();
					System.out.println("Please enter a password: ");
					String password = sc.nextLine();
					
					try {
						u = uServ.signUp(first, last, password);
						System.out.println("You may now log in with the username: " + u.getUserName());
					} catch (Exception e) {
						System.out.println("Sorry, we could not process your request");
						System.out.println("Please try again later");
						done = true;
					}
				}
			} else{
				System.out.println("To view posts press 1:"
						+ "\n to create a post press 2:"
						+ "\n to view balance 3:"
						+ "\n to deposit balance 4:");
				int choice = Integer.parseInt(sc.nextLine());
				//If the user chooses 1, we will show them the list of posts
				if(choice == 1) {
					List<Post> posts = pServ.getAllPosts();
					for(Post post: posts) {
						System.out.println(post.getUser() + ":");
						System.out.println(post.getContent());
						System.out.println();
					}
					System.out.println("Are you finished? Press 1 for yes, press 6 for no");
					choice = Integer.parseInt(sc.nextLine());
					done = (choice == 1) ? true : false;
					
				} else if(choice == 2) {
					System.out.println("Please enter your content below:");
					String content = sc.nextLine();
					Post p = new Post(u.getUserName(), content);
					pServ.addPost(p);
					System.out.println("Post was received, are you finished? Press 1 for yes, press 6 for no");
					choice = Integer.parseInt(sc.nextLine());
					done = (choice == 2) ? true : false;
					
				}else if(choice == 3) {
					List<Accounts> accounts = aServ.getAllBalance();
					for(Accounts account: accounts) {
						System.out.println(account.getBalance() + ":");
						System.out.println(account.getAccountNumber());
//						System.out.println(account.getHolder());
						System.out.println();
					}
					System.out.println("Are you finished? Press 1 for yes, press 6 for no");
					choice = Integer.parseInt(sc.nextLine());
					done = (choice == 3) ? true : false;
					
				}else if(choice == 4) {
					System.out.println("Please enter your amount:");
					int amount = Integer.parseInt(sc.nextLine());
					Accounts acct = new Accounts(u.getUserName(), amount);
					aServ.addBalance(acct);
				
					System.out.println("Post was received, are you finished? Press 1 for yes, press 6 for no");
					choice = Integer.parseInt(sc.nextLine());
					done = (choice == 4) ? true : false;
			}
		}
		
	}
		System.out.println("Goodbye :)");
		sc.close();
	}
}
//	public static void printUserMenu(User theUser, Scanner sc) {
//		
//		//print a summary of the user's accounts
//		theUser.printAccountsSummary();
//		//init
//		int choice;
//		//user menu 
//		do {
//			System.out.printf("Welcome %s, what would you like to do \n", theUser.getFirstName());
//			System.out.println("  1) Show account transaction history");
//			System.out.println("  2) Withdrawl");
//			System.out.println("  3) Deposit");
//			System.out.println("  4) Transfer");
//			System.out.println("  5) View Post");
//			System.out.println("  6) Quit");
//			System.out.println();
//			System.out.println("enter choice: ");
//			choice = sc.nextInt();
//			
//			if(choice<1 || choice>5) {
//				System.out.println("Invalie choice. plase choose 1-5");
//			}
//			
//		}while(choice<1 || choice>5);
//		
//		switch(choice) {
//		case 1:
//			ATM.showTransHistory(theUser, sc);
//			break;
//		case 2:
//			ATM.withdrawFunds(theUser, sc);
//			break;
//		case 3:
//			ATM.depositFunds(theUser, sc);
//			break;
//		case 4:
//			ATM.transferFunds(theUser, sc);
//		}
//		//redisplay this menu unless the user wants to quit
//		if(choice != 5) {
//			ATM.printUserMenu(theUser,  sc);
//			
//		}else {
//			System.out.print("Thank you for being a valued Customer.");
//			System.exit(1);
//		}
//		}
		*/
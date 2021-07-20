import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoDB;
import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoDB;
import com.example.dao.TransactionDao;
import com.example.dao.TransactionDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.Customer;
import com.example.models.Employee;
import com.example.models.Transaction;
import com.example.models.User;
import com.example.services.UserService;

public class BankHubDriver {

	public static void main(String[] args) {
		System.out.println("Project Bank");
		
		UserDao uDao = new UserDaoDB();
		CustomerDao cDao = new CustomerDaoDB();
		AccountDao aDao = new AccountDaoDB();
		EmployeeDao eDao = new EmployeeDaoDB();
		
		
		
		User u = null;
		Customer customer = new Customer();
		UserService uServ = new UserService(uDao, cDao, aDao, eDao);
		//boolean signUp = false;
		boolean run = true;

		Scanner input = new Scanner(System.in);
		
		while (run) {
			if (u == null) {
			System.out.println("1:Signup or 2:Login?");
			//String choice = input.nextLine();
			String choice = "2";
			choice = choice.toLowerCase();		
				if (choice != null) {
					if (choice.equals("1") || choice.equals("sign up") || choice.equals("signup")) {
						/*
						System.out.println("Enter First Name: ");
						String firstName = input.nextLine();
						System.out.println("Enter Last Name: ");
						String lastName = input.nextLine();					
						System.out.println("Enter Email: ");
						String email = input.nextLine();					
						System.out.println("Enter Password: ");
						String password = input.nextLine();
						newCustomer = uServ.signUp(firstName, lastName, email, password);
						 */

						customer = uServ.signUp("Hammus", "Stoick", "ysodara@#$", "passwrod");
						System.out.println("Your registration has completed successfully");	
						u = cDao.getCustomersByCustomerId(customer.getCustomer_id());
						System.out.println(u.getUsername());
						
					}
					else if (choice.equals("2") || choice.equals("log in") || choice.equals("login")) {
//						System.out.println("Enter UserName: ");
//						String username = input.nextLine();					
//						System.out.println("Enter Password: ");
//						String password = input.nextLine();
//						u = uServ.signIn(username, password);
						
						u = uServ.signIn("HammusStoick6919", "passwrod");
						customer = cDao.getCustomersByUsername(u.getUsername());						
					}
				}
				else {
					System.out.println("Invalid input- Not log ing or Sign up");
				}
			
			} else {
				if (u.getRole().equals("Customer")){
					System.out.println(u);
					//Load account from database to customer object
					customer.setAccounts(aDao.getAccountByUsername(u.getUsername()));
					//Check if customer has an account or not
						if (customer.getAccounts().size() == 0) {
							if (customer != null) {						
								u = uServ.getUserbyCustomerId(customer.getCustomer_id());																
								System.out.println("You have no active account with us");
								System.out.println("Are you ready to apply?");
								String choiceApply = input.nextLine();
								choiceApply = choiceApply.toLowerCase();
								
								if (choiceApply.equals("1") || choiceApply.equals("y") || choiceApply.equals("yes")) {
									customer = applyForAccount(customer);							
								}
								else {
									run = false;
									System.out.println("Good Bye.");
								}						
							}
						}
						//Customer has an account 
						//Need to show all available user action of the program
						else {
							
							customer.printUserAllAccount();
							boolean check = false;
							check = customer.checkActiveAccounts();
							if (check) {
							run = false;
							boolean customerActionCheck = true;
							input = new Scanner(System.in);

								while(customerActionCheck) {
									
									System.out.println("Available Options");
									System.out.println("1. Apply for an account");
									System.out.println("2. View account");
									System.out.println("3. Withdrawl");
									System.out.println("4. Deposit");
									System.out.println("5. Send money");
									System.out.println("6. View pending incoming transfer");
									System.out.println("7. Log out");
									System.out.print("Go To: ");
									int actionChoice = input.nextInt();
									
									switch(actionChoice) {
									case 1: {
										customer = applyForAccount(customer);
										break;
									}
									case 2:	{
										printCustomerAccount(customer);
										break;
									}
									case 3:	{
										customer = withdrawl (customer, aDao, u,uServ);
										
										break;
									}
									case 4:	{
										customer = deposit (customer, aDao, u,uServ);
										break;
									}
									case 5:	{
										sendMoney(customer,uServ);
										break;
									}
									case 6:	{
										uServ.printSendingMoney();
										break;
									}
									case 7:{
										customerActionCheck = false;
										System.out.println("logged out");
										break;
									}
									default: {
										System.out.println("Action Coming soon!");
										break;
									}
									
									}
									
								}
							} //No active account
							else {
								run = false;
							}
						}										
					
					System.out.println();
				}
				else {
					//Employee
					//Approve or reject an account
					//View customer bank account
					//View log all transaction
					//employee
				}
				//user is logged in
			}

		}
		
		input.close();
			
	}
	public static void sendMoney (Customer sender, UserService uServ) {
		printActiveAccount(sender);
		String recieverUsername = "";
		Scanner input = new Scanner(System.in);
		System.out.print("Choose account to send: ");
		int choice = input.nextInt();
		if (choice < 0 | choice > sender.getActiveAccounts().size()){
			System.out.println("Input does not match any account in the System.");
		} else {
			Scanner input2 = new Scanner(System.in);
			double currentBalance = sender.getAccounts().get(choice).getCurrent_balance();
			System.out.println("Balance available to send: " + currentBalance);
			
			System.out.print("Enter Username to send: ");
			recieverUsername = input2.nextLine();
			
			System.out.print("Enter amount: ");
			double amountToSend = input2.nextDouble();
			if (currentBalance - amountToSend <0) {
				System.out.println("Insufficient Balance!");
			}else {
			
				uServ.sendMoney(sender, currentBalance, recieverUsername, amountToSend, choice);
			}
			
		}
		
	}
	
	public static void printActiveAccount (Customer c) {
		for (int i = 0 ; i < c.getActiveAccounts().size(); i++) {
			int label = i + 1;
			System.out.println("Account "+ (i+1) +": "+c.getActiveAccounts().get(i).getName());	
		}
	}
	
	public static Customer withdrawl (Customer c, AccountDao aDao, User u, UserService uServ) {
		//when succedd -> c.setAccounts(aDao.getAccountByUsername(u.getUsername()));
		printActiveAccount(c);
		Scanner input = new Scanner(System.in);
		System.out.print("Choose account to withdrawl: ");
		int choice = input.nextInt();
		
		if (choice < 0 | choice > c.getActiveAccounts().size()){
			System.out.println("Input does not match any account in the System.");
		} else {
			double currentBalance = c.getAccounts().get(choice).getCurrent_balance();
			System.out.print("Enter Amount: ");
			double amountToWithdrawl = input.nextDouble();
			
			if ((currentBalance - amountToWithdrawl) < 0) {
				System.out.println("Insufficient Balance!");
			}
			
			else {
				double updateBalance = currentBalance  - amountToWithdrawl;
				Account accountToUpdate = c.getAccounts().get(choice);
				accountToUpdate.setCurrent_balance(updateBalance);
				boolean succeed = aDao.updateAccount(accountToUpdate);
				
				if (succeed) {
					System.out.println("Withdrawl Amount: "+amountToWithdrawl);
					System.out.println("Your Current balance: "+updateBalance);
					c.setAccounts(aDao.getAccountByUsername(u.getUsername()));
					uServ.uploadTransaction(amountToWithdrawl, "Withdrawl", c, c.getAccounts().get(choice).getAccount_id());
					
				} else {
					System.out.println("Update failed");
				}
				
				
			}
			
		}
		return c;
	}
	
	public static Customer deposit (Customer c, AccountDao aDao, User u, UserService uServ) {
		//when succedd -> c.setAccounts(aDao.getAccountByUsername(u.getUsername()));
		printActiveAccount(c);
		Scanner input = new Scanner(System.in);
		System.out.print("Choose account to deposit: ");
		int choice = input.nextInt();
		
		if (choice < 0 | choice > c.getActiveAccounts().size()){
			System.out.println("Input does not match any account in the System.");
		} else {
			double currentBalance = c.getAccounts().get(choice).getCurrent_balance();
			System.out.print("Enter Amount: ");
			double amountToDepost= input.nextDouble();
			
			if ((amountToDepost) < 0) {
				System.out.println("Invalid Deposit amount!");
			}
			
			else {
				double updateBalance = currentBalance  + amountToDepost;
				Account accountToUpdate = c.getAccounts().get(choice);
				accountToUpdate.setCurrent_balance(updateBalance);
				boolean succeed = aDao.updateAccount(accountToUpdate);
				
				if (succeed) {
					System.out.println("Deposit Amount: "+amountToDepost);
					System.out.println("Your Current balance: "+updateBalance);
					c.setAccounts(aDao.getAccountByUsername(u.getUsername()));
					uServ.uploadTransaction(amountToDepost, "Deposit", c , c.getAccounts().get(choice).getAccount_id());
					
				} else {
					System.out.println("Update failed");
				}
				
				
			}
			
		}
		return c;
	}
	public static void printCustomerAccount(Customer c) {
		printActiveAccount(c);
		Scanner input = new Scanner(System.in);
		System.out.print("Choose account to view: ");
		int choice = input.nextInt();

		System.out.println();
		System.out.println();
		if (choice < 0 | choice > c.getActiveAccounts().size()){
			System.out.println("Input does not match any account in the System.");
		} else {
			System.out.println("Account Name: "+c.getActiveAccounts().get(choice-1).getName() + "\nBalance: " + c.getActiveAccounts().get(choice-1).getCurrent_balance());
		}
		
		
		System.out.println("Now back at main menu");
		
	}
	public static Customer applyForAccount (Customer c) {
		UserDao uDao = new UserDaoDB();
		CustomerDao cDao = new CustomerDaoDB();
		AccountDao aDao = new AccountDaoDB();
		EmployeeDao eDao = new EmployeeDaoDB();
		UserService uServ = new UserService(uDao, cDao, aDao, eDao);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Account Name: ");
		String accountName = input.nextLine();
		System.out.println("Enter Starting balance: ");
		double sBalance = input.nextDouble();		
		c = uServ.bankAccoutRegistration(c, accountName, sBalance);
		return c;
	}

	

	
	

}

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
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.Customer;
import com.example.models.Employee;
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

						customer = uServ.signUp("Hammus", "Stoick", "ysodara1211", "passwrod");
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
							run = false;
							boolean customerActionCheck = true;
							input = new Scanner(System.in);
							

							//Customer methods
	//						view specific my own bank account
	//						withDraw or deposit to a specific account
	//						System check for transacation validation
	//						post a money transfer
	//						accept a money transfer from another account "Maybe other users"
							while(customerActionCheck) {
								System.out.print("Go To: ");
								System.out.print("");
								int actionChoice = input.nextInt();
								
								switch(actionChoice) {
								case 1: {
									System.out.println("1");
									break;
								}
								case 2:	{
									System.out.println("2");
									break;
								}
								case 3:	{
									System.out.println("3");
									break;
								}
								case 4:	{
									System.out.println("4");
									break;
								}
								case 5:	{
									System.out.println("5");
									break;
								}
								case 6:	{
									customerActionCheck = false;
									System.out.println("6");
									break;
								}
								default: {
									System.out.println("Action Coming soon!");
									break;
								}
								
								}
								
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

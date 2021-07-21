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
import com.example.dao.SendMoneyDao;
import com.example.dao.SendMoneyDaoDB;
import com.example.dao.TransactionDao;
import com.example.dao.TransactionDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.AllUserAccount;
import com.example.models.Customer;
import com.example.models.Employee;
import com.example.models.SendMoney;
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
		Employee employee = new Employee();
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

//						customer = uServ.signUp("danny", "Stk", "danny99", "passwrod");
//						System.out.println("Your registration has completed successfully");	
//						u = cDao.getCustomersByCustomerId(customer.getCustomer_id());
//						System.out.println(u.getUsername());
						
					}
					
					else if (choice.equals("2") || choice.equals("log in") || choice.equals("login")) {
						boolean succeed = false;
						while (!succeed) {
							
//							System.out.println("Enter UserName: ");
//							String username = input.nextLine();					
	//						System.out.println("Enter Password: ");
	//						String password = input.nextLine();
	//						u = uServ.signIn(username, password);
							
							
							User temp = uServ.signIn("dannyStk6150", "passwrod");
							
							boolean check = checkUser(temp);
							
							if (check) {
								succeed = true;
								u = temp;
							} else {
								System.out.println("Invalid Credentials");
								System.out.println("Retry?");
								String retry = input.nextLine();
								retry = retry.toLowerCase();
								if (retry.equals("1") || retry.equals("y") || retry.equals("yes")) {
									succeed = false;
								}
								else {
								succeed = true;
								}
								
							}
						}
											
					}
				}
				else {
					System.out.println("Invalid input- Not log ing or Sign up");
				}
			
			} else {
				//Start Role of Cusomer
				if (u.getRole().equals("Customer")){
					customer = cDao.getCustomersByUsername(u.getUsername());
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
										acceptMoney(customer, aDao, u,uServ);
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
				} // End Role of Cusomer
				
				//Start Role of Employee
				else if (u.getRole().equals("Employee"))
				{
					run = false;
					System.out.println(u);
					employee = eDao.getEmployeeByUsername(u.getUsername());
					boolean employeeActionCheck = true;
					Scanner employeeInput = new Scanner(System.in);
					while (employeeActionCheck) {
						System.out.println("Available Options");
						System.out.println("1. Approve or Reject Account");
						System.out.println("2. View a Customer's bank accounts");
						System.out.println("3. View Log of all Transaction");
						System.out.println("4. Exit");
						int actionChoice = employeeInput.nextInt();
						
							switch(actionChoice) {
							case 1: {
								modifyCustomerAccount(uServ);
								
								
								break;
							}
							case 2:	{
								ViewCustomerAccounts(uServ,cDao, aDao);
								break;
							}
							case 3:	{
								
								uServ.printAllTractions();
								//View log all transaction
								
								break;
							}
							case 4:	{
								employeeActionCheck = false;
								break;
							}
							}
						
						
						
					}
					//Employee
					//Approve or reject an account
					
					
					//employee
				}
				//user is logged in
				else {
					System.out.println("Unknown role, break now");
					run = false;
				}
			}

		}
		
		input.close();
			
	}
	public static void ViewCustomerAccounts(UserService uServ, CustomerDao cDao, AccountDao aDao) {
		//CustomerDao cDao = new CustomerDaoDB();
		List<User> users = uServ.getAllUsers();
		printAllCustomerHelper(users);
		System.out.println();
		
		Scanner employeeInput = new Scanner(System.in);
		System.out.print("Select User to View: ");
		int actionChoice = employeeInput.nextInt();
		
		if(actionChoice <1 | actionChoice > users.size()) {
			System.out.println("Invalid choice");
		}
		else {
			actionChoice = actionChoice -1;
			List<Account> accountList = uServ.getAccountByUsername(users.get(actionChoice).getUsername());
			for (int i = 0; i < accountList.size(); i++) {
				//System.out.println(i+1+".Customer Name: " + accountList.get(i).getFirstName() + " " +accountList.get(i).getLastName());
				if (accountList.get(i).isApproval_status())
				System.out.println(i+1+".Account Name: " + accountList.get(i).getName() + ", Status: ACTIVE" + ", Balance: " +accountList.get(i).getCurrent_balance() );
				else {
					System.out.println(i+1+".Account Name: " + accountList.get(i).getName() + ", Status: Under Review" + ", Balance: " +accountList.get(i).getCurrent_balance() );
				}
			}
			
		}
	}
	
	public static void printAllCustomerHelper(List<User> users) {
		System.out.println("\nAll Customers:\n");
		for (int i = 0 ; i< users.size(); i++) {
			System.out.println((i+1)+ ".Customer Name: " +users.get(i).getFirstName() + users.get(i).getLastName() );
			System.out.println("  Username: " +users.get(i).getUsername());
			System.out.println("  Email: " +users.get(i).getEmail());
		}
	}
	public static void modifyCustomerAccount (UserService uServ) {
		List<AllUserAccount> allAccountList = uServ.getAllAccounts();
		uServ.printAllAccounts(allAccountList);
		
		Scanner employeeInput = new Scanner(System.in);
		System.out.print("Enter Account to Modify: ");
		int actionChoice = employeeInput.nextInt();
		System.out.print("Enter Status: ");
		boolean status = employeeInput.nextBoolean();
		if (actionChoice < 1 | actionChoice > allAccountList.size()) {
			System.out.println("Invalid");
		} else {
			actionChoice = actionChoice - 1;
			uServ.modifyCustomerAccount(allAccountList, actionChoice ,status);
		}
		
		
		
		
		
	}
	public static boolean checkUser(User u) {
		if (u == null) {
			return false;
		} else {
			return true;
		}
			
	}
	public static void printAllAcceptMoney(List<SendMoney> list) {
		for (int i = 0 ; i < list.size() ; i ++) {
		System.out.println(list.get(i));
	}
	} 
	public static void acceptMoney (Customer c, AccountDao aDao, User u, UserService uServ) {
		SendMoneyDao sDao = new SendMoneyDaoDB();
		List<SendMoney> pendingMoney = uServ.acceptMoney(c.getCustomer_id());
		int size = pendingMoney.size();
		Scanner in = new Scanner(System.in);
		if (size <=0) {
			System.out.println("You have no incoming transfer");
		} else {
			printAllAcceptMoney(pendingMoney);
			System.out.println("You have some incoming transfer");
			System.out.print("Choose transfer to accept: ");
			int choice = in.nextInt();
			if (choice < 1 | choice > size){
				System.out.println("Input does not match any account in the System.");
			} else {
				choice = choice - 1;
				double amountToDeposit = pendingMoney.get(choice).getAmount();
				
				printActiveAccount(c);
				System.out.print("Choose account to deposit: ");
				int choiceAccount = in.nextInt();
				
				if (choiceAccount < 1 | choiceAccount > c.getActiveAccounts().size()){
					System.out.println("Input does not match any account in the System.");
				} else {
					choiceAccount = choiceAccount - 1;
					double currentBalance = c.getAccounts().get(choiceAccount).getCurrent_balance();
					
					double updateBalance = currentBalance  + amountToDeposit;
					Account accountToUpdate = c.getAccounts().get(choice);
					accountToUpdate.setCurrent_balance(updateBalance);
					
					boolean succeed = aDao.updateAccount(accountToUpdate);
					
					if (succeed) {
						System.out.println("Deposit Amount: "+amountToDeposit);
						System.out.println("Your Current balance: "+updateBalance);
						c.setAccounts(aDao.getAccountByUsername(u.getUsername()));
						
						uServ.uploadTransaction(amountToDeposit, "Accepted", c , c.getAccounts().get(choiceAccount).getAccount_id());
						pendingMoney.get(choice).setStatus(true);
						SendMoney s = pendingMoney.get(choice);
						sDao.updateSendMoney(s);
						
					} else {
						System.out.println("Update failed");
					}
					
					
				}
				
				
			}
		}
		
		
		
		
	}
	public static Customer deposit (Customer c, AccountDao aDao, User u, UserService uServ) {
		//when succedd -> c.setAccounts(aDao.getAccountByUsername(u.getUsername()));
		printActiveAccount(c);
		Scanner input = new Scanner(System.in);
		System.out.print("Choose account to deposit: ");
		int choice = input.nextInt();
		
		if (choice < 1 | choice > c.getActiveAccounts().size()){
			System.out.println("Input does not match any account in the System.");
		} else {
			choice = choice -1;
			double currentBalance = c.getAccounts().get(choice).getCurrent_balance();
			System.out.print("Enter Amount: ");
			double amountToDeposit= input.nextDouble();
			
			if ((amountToDeposit) < 0) {
				System.out.println("Invalid Deposit amount!");
			}
			
			else {
				double updateBalance = currentBalance  + amountToDeposit;
				Account accountToUpdate = c.getAccounts().get(choice);
				accountToUpdate.setCurrent_balance(updateBalance);
				boolean succeed = aDao.updateAccount(accountToUpdate);
				
				if (succeed) {
					System.out.println("Deposit Amount: "+amountToDeposit);
					System.out.println("Your Current balance: "+updateBalance);
					c.setAccounts(aDao.getAccountByUsername(u.getUsername()));
					uServ.uploadTransaction(amountToDeposit, "Deposit", c , c.getAccounts().get(choice).getAccount_id());
					
				} else {
					System.out.println("Update failed");
				}
				
				
			}
			
		}
		return c;
	}
	public static void sendMoney (Customer sender, UserService uServ) {
		printActiveAccount(sender);
		String recieverUsername = "";
		Scanner input = new Scanner(System.in);
		System.out.print("Choose account to send: ");
		int choice = input.nextInt();
		if (choice < 1 | choice > sender.getActiveAccounts().size()){
			System.out.println("Input does not match any account in the System.");
		} else {
			choice = choice -1;
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
		
		if (choice < 1 | choice > c.getActiveAccounts().size()){
			System.out.println("Input does not match any account in the System.");
		} else {
			choice = choice - 1;
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

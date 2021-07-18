import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.Customer;
import com.example.models.User;
import com.example.services.UserService;

public class BankHubDriver {

	public static void main(String[] args) {
		System.out.println("Project Bank");
		
		UserDao uDao = new UserDaoDB();
		CustomerDao cDao = new CustomerDaoDB();
		AccountDao aDao = new AccountDaoDB();
		
		
		//User u = new User();
		
		UserService uServ = new UserService(uDao, cDao, aDao);
		
		//Customer newUser = uServ.signUp("Jons", "Hank", "jhank56", "passwrod");
		
		
		//System.out.println(newUser);
		
		//Apply for banks account
		//newUser = uServ.bankAccoutRegistration(newUser, "Checking", 25);
		//System.out.println(cDao.getCustomersByUsername("JonsHank7206"));
//		Account a = new Account();
//		aDao.getAccountByUsername("JonsHank6671");
		//Customer C = new Customer();
		//C.setAccounts(aDao.getAccountByUsername("JonsHank6671"));
		//System.out.println(C.getAccounts().get(1));
		
		Customer loggingC = uServ.signIn("JonsHank6671", "passwrod");

	}


}

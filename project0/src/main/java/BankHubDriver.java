import java.sql.SQLException;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Customer;
import com.example.models.User;
import com.example.services.UserService;

public class BankHubDriver {

	public static void main(String[] args) {
		System.out.println("Project Bank");
		
		UserDao uDao = new UserDaoDB();
		CustomerDao cDao = new CustomerDaoDB();
		
		
		User u = new User();
		
		UserService uServ = new UserService(uDao, cDao);
		
		User jons = uServ.signUp("Jons", "Hanks", "jhank8978s", "passwrods");
		
		
		
		
		
		
		

	}
	
	public User signUp(String first, String last, String email, String password) throws UserNameAlreadyExistsException{
		UserDao uDao = new UserDaoDB();
		User u = new User(first, last, email, password);
		
		try {
			uDao.createUser(u);
			Logging.logger.info("New user has registered");
		} catch(SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		
		return u;
	}

}

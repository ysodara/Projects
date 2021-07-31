import java.io.IOException;
import java.util.List;

import com.example.controllers.LoginController;
import com.example.dao.ReimburstmentDao;
import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.ReimBType;
import com.example.models.Reimburstment;
import com.example.models.User;
import com.example.models.UserRole;
import com.example.services.UserService;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr.Role;
import com.example.models.UserRole;
import com.example.utils.HibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;


public class ReimBDriver {
	
	public static void main(String[] args) throws JsonProcessingException, IOException, UserDoesNotExistException, InvalidCredentialsException {
		UserDao uDao = new UserDao();
		ReimburstmentDao rDao = new ReimburstmentDao();
		UserService userv = new UserService(uDao);
		
		User u = userv.signIn("JJ12", "passwords");
		System.out.println(u.toString());
//		UserRole employeeRole = new UserRole();
//		employeeRole.setUserRole("MANAGER");
//		employeeRole.setUserRoleId(2);
		//String firstName, String lastName, String email, String password, UserRole userRole
		//User u1= new User("firstname","lastname", "email@", "password", employeeRole);
		//uDao.insert(u1);
		
//		List<User> ulist = uDao.selectAll();
//		
//		User u = uDao.selectUserByUsername("s");
//		
//		u = uDao.selectUser(1);
//		
//		
//		List<Reimburstment> r = rDao.selectEmployeePendingTickets();
//		
//		
//		List<Reimburstment> r1 = rDao.selectEmployeeResovledTickets();
//		
//		
//		List<Reimburstment> r2 = rDao.selectEmployeeTickets(1);
//		
//		
//		List<Reimburstment> r3 = rDao.selectPendingTickets(1);
//		
//		
//		List<Reimburstment> r4 = rDao.selectResovledTickets(1);
		
		
		
//		System.out.println("-------------------------------------------------------------");
//		System.out.println("User: ");
//		System.out.println(u.toString());
//		System.out.println("-------------------------------------------------------------");
//		
//		
//		System.out.println("-------------------------------------------------------------");
//		System.out.println("View all pending requests of all employees");
//		System.out.println(r.toString());
//		System.out.println("-------------------------------------------------------------");
//		
//		System.out.println("-------------------------------------------------------------");
//		System.out.println("View all resolved requests of all employees");
//		System.out.println(r1.toString());
//		System.out.println();
//		
//		System.out.println("View reimbursement requests of a specific employee");
//		System.out.println(r2.toString());
//		System.out.println("-------------------------------------------------------------");
//		
//		System.out.println("View pending reimbursement requests for employee");
//		System.out.println(r3.toString());
//		System.out.println("-------------------------------------------------------------");
//		System.out.println("View resolved reimbursement requests for employee");
//		System.out.println(r4.toString());
//		System.out.println("-------------------------------------------------------------");
		
		
		//HibernateUtil.closeSession();
	}

}

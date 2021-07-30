import com.example.dao.UserDao;
import com.example.models.ReimBType;
import com.example.models.User;
import com.example.models.UserRole;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr.Role;
import com.example.models.UserRole;
import com.example.utils.HibernateUtil;


public class ReimBDriver {
	
	public static void main(String[] args) {
		UserDao uDao = new UserDao();
		
		
		UserRole employeeRole = new UserRole();
		employeeRole.setUserRole("MANAGER");
		employeeRole.setUserRoleId(2);
		//String firstName, String lastName, String email, String password, UserRole userRole
		User u1= new User("firstname","lastname", "email@", "password", employeeRole);
		uDao.insert(u1);
		HibernateUtil.closeSession();
		
		
	}

}

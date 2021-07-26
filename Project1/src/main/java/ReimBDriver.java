import com.example.models.ReimBType;
import com.example.models.UserRole;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr.Role;



public class ReimBDriver {
	
	public static void main(String[] args) {
		
		UserRole userRole = new UserRole();
		
		userRole.setUserRole(2);
		
		userRole.roleIsWho();
		
		ReimBType rbType = new ReimBType();
		
		rbType.setReimBtype(2);
		
		rbType.printReimBType();
		
	}

}

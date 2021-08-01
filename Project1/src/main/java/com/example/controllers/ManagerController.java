package com.example.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ReimburstmentDao;
import com.example.dao.UserDao;
import com.example.models.Reimburstment;
import com.example.services.ManagerService;

public class ManagerController {
	private static UserDao uDao = new UserDao();
	private static ReimburstmentDao rDao = new ReimburstmentDao();
	private static ManagerService mServ = new ManagerService(uDao, rDao);

	public static void approveOrDeny(HttpServletRequest req, HttpServletResponse res) {
		// Reimburstment approveRequest(int rId, int mId)
		// Reimburstment denyRequest(int rId, int mId)
		
	}

	public static void pendingEmployees(HttpServletRequest req, HttpServletResponse res) {
		// viewAllPendingAllEmploye
		
	}

	public static void resolvedEmployees(HttpServletRequest req, HttpServletResponse res) {
		// viewAllResovledAllEmployee
		
	}

	public static void specificEmployees(HttpServletRequest req, HttpServletResponse res) {
		// viewAllRequestOfEmployee(int id) Employee ID
		
	}
	public static void allEmployees(HttpServletRequest req, HttpServletResponse res) {
		// viewAllEmployee()
		
	}

}

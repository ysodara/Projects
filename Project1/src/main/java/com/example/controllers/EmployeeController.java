package com.example.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.ReimburstmentDao;
import com.example.dao.UserDao;
import com.example.models.Reimburstment;
import com.example.models.User;
import com.example.services.EmployeeService;
import com.example.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeController {
	private static UserDao uDao = new UserDao();
	private static ReimburstmentDao rDao = new ReimburstmentDao();
	private static EmployeeService eServ = new EmployeeService(uDao,rDao);
	
	public static String dataHelper (HttpServletRequest req) throws IOException {
		//To read in stringified JSON data is a bit more complicated,
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		
		String line;
		while((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		String data = buffer.toString();

		return data;
	}
	
	public static void submit(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		String data = dataHelper(req);
		

		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);
		
		
		//double amount, String description, int employeeId, int typeId, String type
		
		double amount = parsedObj.get("amount").asDouble();
		String description = parsedObj.get("description").asText();
		int employeeId = parsedObj.get("employeeId").asInt();
		int typeId = parsedObj.get("typeId").asInt();
		String type = parsedObj.get("type").asText();
		
		
		try {
			//We will keep track of if the user is logged in by storing their id in the session
			//req.getSession().setAttribute("id", u.getId());
			Reimburstment r = eServ.submit(amount, description, employeeId, typeId, type);
			res.setStatus(HttpServletResponse.SC_OK);
			
			res.getWriter().write(new ObjectMapper().writeValueAsString("Reiemburstment successfully added." + r));
		}
		catch(Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Add failed");
		}
	
	}
	
	public static void viewPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		HttpSession session = req.getSession(true);
		
		int employeeId = (int)session.getAttribute("id");
		try {
			//We will keep track of if the user is logged in by storing their id in the session
			req.getSession().setAttribute("id", employeeId);
			res.setStatus(HttpServletResponse.SC_OK);
			List<Reimburstment> lRB = eServ.viewPendingRequests(employeeId);
			res.getWriter().write(new ObjectMapper().writeValueAsString(lRB));
		}
		catch(Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Request fails");
		}
		
	}
	
	public static void viewResolved(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		HttpSession session = req.getSession(true);
		
		int employeeId = (int)session.getAttribute("id");
		try {
			//We will keep track of if the user is logged in by storing their id in the session
			req.getSession().setAttribute("id", employeeId);
			res.setStatus(HttpServletResponse.SC_OK);
			List<Reimburstment> lRB = eServ.viewResolvedRequests(employeeId);
			res.getWriter().write(new ObjectMapper().writeValueAsString(lRB));
		}
		catch(Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Request fails");
		}
		
	}
	
	public static void viewAccount(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		HttpSession session = req.getSession(true);
		
		int employeeId = (int)session.getAttribute("id");
		try {
			//We will keep track of if the user is logged in by storing their id in the session
			req.getSession().setAttribute("id", employeeId);
			res.setStatus(HttpServletResponse.SC_OK);
			User u = eServ.viewAccountInfo(employeeId);
			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
		}
		catch(Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Request fails");
		}
		
	}
	
	
	public static void updateAccount(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		//HttpSession session = req.getSession(true);
		String data = dataHelper(req);
		//int employeeId = (int)session.getAttribute("id");
		
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);
		
		
		//int id, String email, String firstName, String LastName, String password, String username
		int employeeId = parsedObj.get("employeeId").asInt();
		String email = parsedObj.get("email").asText();
		String firstName = parsedObj.get("firstName").asText();
		String lastName = parsedObj.get("lastName").asText();
		String password = parsedObj.get("password").asText();
		String username = parsedObj.get("username").asText();
		
		try {
			//We will keep track of if the user is logged in by storing their id in the session
			req.getSession().setAttribute("id", employeeId);
			res.setStatus(HttpServletResponse.SC_OK);
			User u = eServ.updateAccountInfo(employeeId, email, firstName, lastName, password, username);
			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
		}
		catch(Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Request fails");
		}
		
	}
}

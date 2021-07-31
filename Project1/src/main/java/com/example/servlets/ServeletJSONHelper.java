package com.example.servlets;

import com.example.controllers.*;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ServeletJSONHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("In the ServletJSONHelper with URI: " + req.getRequestURI());
		String uri = req.getRequestURI();
		switch (uri) {
			case "/Project1/api/login": {
				LoginController.login(req,res);
				break;
			}
			case "/Project1/api/submit": {
				ReimbursmentCustomerController.submit(req,res);
				break;
			}
			case "/Project1/api/viewpending": {
				ReimbursmentCustomerController.viewPending(req,res);
				break;
			}
			
			case "/Project1/api/viewresolved": {
				ReimbursmentCustomerController.viewResolved(req,res);
				break;
			}
			
			case "/Project1/api/logout": {
				LogoutController.logout(req,res);
				break;
			}
		
		}
		
	}

}

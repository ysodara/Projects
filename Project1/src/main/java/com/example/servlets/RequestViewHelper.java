package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.example.controllers.*;


public class RequestViewHelper {

	public static String process(HttpServletRequest req) throws ServletException, IOException {
		switch(req.getRequestURI()) {
		case "/Project1/home":
			return LoginViewController.fetchHomePage(req);
		}
	return "/Project1/error";
	}

}

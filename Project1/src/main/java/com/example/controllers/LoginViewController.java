package com.example.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class LoginViewController {
	public static String fetchLoginPage (HttpServletRequest req) throws ServletException, IOException {
		return "resources/html/login.html";
	}
}

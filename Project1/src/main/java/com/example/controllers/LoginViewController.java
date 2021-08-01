package com.example.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.example.utils.HibernateUtil;

public class LoginViewController {
	public static String fetchHomePage (HttpServletRequest req) throws ServletException, IOException {
		//Session ses = HibernateUtil.getSession();
		return "resources/html/login.html";
	}
}

package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.User;
import com.example.utils.HibernateUtil;

public class UserDao {
	
	

	public UserDao() {}
	
	
	public void insert(User u) {
		//Opening up a session in Hibernate
		Session ses = HibernateUtil.getSession();
		
		//We must start a transaction
		Transaction tx=ses.beginTransaction();
		
		ses.save(u);
		
		tx.commit();
		
	}
	
	public User selectUser(int id) {
		Session ses = HibernateUtil.getSession();
		//If you are using ses.get(), you must use the id
		User u = ses.get(User.class, id);
		//ses.close();
		return u;
	}
	
	public User selectUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		//If you are using ses.get(), you must use the id
		List<User> u = ses.createQuery("from User where username= '" + username + "'", User.class).list();
		if(u.size() == 0) {
			return null;
		}
		return u.get(0);
	}
	
	public List<User> selectAll(){
		Session ses = HibernateUtil.getSession();
		//This is how we select all entries in a table with HQL
		//HQL is based off of our Java objects, not the table in the db, 
		//Hibernate translates this HQL into native SQL
		List<User> uList = ses.createQuery("from User", User.class).list();
		return uList;
	}
	
}
	
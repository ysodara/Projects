package com.example.Dao;

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
	
}
	

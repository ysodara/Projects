package com.example.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimburstments")
public class Reimburstment {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbId;
	
	@Column(name="amount", nullable =false)
	private double amount;
	
	@Column(name="description", nullable =false)
	private String description;
	
	@Column(name="reciept", nullable =true)
	private String reciept;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="employee_submit_FK")
	private User submitted;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="manager_resovle_FK")
	private User resovled;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="type_FK")
	private ReimBType type;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="status_FK")
	private ReimBStatus status;
	
	public Reimburstment () {
		
	}
	//For setting for Employee to database
	public Reimburstment (double amount, String description, String reciept, User submitted, ReimBType type, ReimBStatus status) {
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.reciept = reciept;
		this.type = type;
		this.status = status;
		this.resovled = new User();
	}
	
	
	public void setReiemburstmentEmployee (int reimId, double amount, User submitted, String description, String reciept) {
		this.reimbId = reimId;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.reciept = reciept;
	}
	
	public void setReiemburstmentManager (int reimId, double amount, User resovled, String description, String reciept) {
		this.reimbId = reimId;
		this.amount = amount;
		this.resovled = resovled;
		this.description = description;
		this.reciept = reciept;
	}
	
	
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public User getSubmitted() {
		return submitted;
	}
	public void setSubmitted(User submitted) {
		this.submitted = submitted;
	}
	public User getResovled() {
		return resovled;
	}
	public void setResovled(User resovled) {
		this.resovled = resovled;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReciept() {
		return reciept;
	}
	public void setReciept(String reciept) {
		this.reciept = reciept;
	}
	
	
	
}

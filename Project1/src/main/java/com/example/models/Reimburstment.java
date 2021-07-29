package com.example.models;

public class Reimburstment {
	private int reimbId;
	private double amount;
	private boolean submitted;
	private boolean resovled;
	private String description;
	private String reciept;
	
	public Reimburstment () {
		
	}
	public Reimburstment (int reimId, double amount, boolean submitted, boolean resovled, String description, String reciept) {
		this.reimbId = reimId;
		this.amount = amount;
		this.submitted = submitted;
		this.resovled = resovled;
		this.description = description;
		this.reciept = reciept;
	}
	
	public Reimburstment (double amount, boolean submitted, boolean resovled, String description, String reciept) {
		this.amount = amount;
		this.submitted = submitted;
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
	public boolean isSubmitted() {
		return submitted;
	}
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	public boolean isResovled() {
		return resovled;
	}
	public void setResovled(boolean resovled) {
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

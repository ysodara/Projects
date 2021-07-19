package com.example.models;

public class SendMoney {
	private int sendMoney_id;
	private String description;
	private boolean status;
	private double amount;
	private int sender_customer_id;
	private int reviever_customer_id;

	public SendMoney() {
		
	}
	public SendMoney(String description, boolean status, double amount,int sender_customer_id,int reviever_customer_id) {
	this.description = 	description;
	this.status = status;
	this.amount = amount;
	this.sender_customer_id = sender_customer_id;
	this.reviever_customer_id = reviever_customer_id;
	}
	
	public SendMoney(int sendMoney_id,String description, boolean status, double amount,int sender_customer_id,int reviever_customer_id) {
		this.sendMoney_id = sendMoney_id;
		this.description = 	description;
		this.status = status;
		this.amount = amount;
		this.sender_customer_id = sender_customer_id;
		this.reviever_customer_id = reviever_customer_id;
	}
	public int getSendMoney_id() {
		return sendMoney_id;
	}
	public void setSendMoney_id(int sendMoney_id) {
		this.sendMoney_id = sendMoney_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getSender_customer_id() {
		return sender_customer_id;
	}
	public void setSender_customer_id(int sender_customer_id) {
		this.sender_customer_id = sender_customer_id;
	}
	public int getReviever_customer_id() {
		return reviever_customer_id;
	}
	public void setReviever_customer_id(int reviever_customer_id) {
		this.reviever_customer_id = reviever_customer_id;
	}
	@Override
	public String toString() {
		return "SendMoney [sendMoney_id=" + sendMoney_id + ", description=" + description + ", status=" + status
				+ ", amount=" + amount + ", sender_customer_id=" + sender_customer_id + ", reviever_customer_id="
				+ reviever_customer_id + "]";
	}
	
	
	
	
	
	
}


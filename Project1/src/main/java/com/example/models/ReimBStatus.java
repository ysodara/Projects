package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimburstment_statuses")
public class ReimBStatus {
	
	@Id
	@Column(name="reimb_status_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimBStatusId;
	
	@Column(name="reimb_status", unique=true, nullable=false)
	private String reimBStatus;
	
	public ReimBStatus () {	
	}
	
	public ReimBStatus (String status) {
		this.reimBStatus=status;
	}
	
	public int getReimBStatusId() {
		return reimBStatusId;
	}
	
	public void setReimBStatusId(int reimBStatusId) {
		this.reimBStatusId = reimBStatusId;
	}
	
	public String getReimBStatus() {
		return reimBStatus;
	}
	
	public void setReimBStatus(String reimBStatus) {
		this.reimBStatus = reimBStatus;
	}
	
	
	
	
}

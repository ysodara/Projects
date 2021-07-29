package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimburstment_statuses")
public class ReimBStatus {
	
	@Id
	@Column(name="reimb_status_id")
	private int reimBStatusId;
	
	@Column(name="reimb_status", unique=true, nullable=false)
	private boolean reimBStatus;
	
	public ReimBStatus () {	
	}
	
	public ReimBStatus (boolean status) {
		this.reimBStatus=status;
	}
	
	public int getReimBStatusId() {
		return reimBStatusId;
	}
	
	public void setReimBStatusId(int reimBStatusId) {
		this.reimBStatusId = reimBStatusId;
	}
	
	public boolean isReimBStatus() {
		return reimBStatus;
	}
	
	public void setReimBStatus(boolean reimBStatus) {
		this.reimBStatus = reimBStatus;
	}
	
	
	
	
}

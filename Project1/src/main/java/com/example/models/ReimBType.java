package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimburstment_types")
public class ReimBType {
	
	@Id
	@Column(name="reimb_type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimBTypeId;
	
	@Column(name="reimb_type", unique=true, nullable=false)
	private String reimBType;
	
	public ReimBType() {		
	}
	
	public ReimBType(String type) {
		this.reimBType=type;
	}
	
	public int getReimBTypeId() {
		return reimBTypeId;
	}
	
	public void setReimBTypeId(int reimBTypeId) {
		this.reimBTypeId = reimBTypeId;
	}
	
	public String getReimBType() {
		return reimBType;
	}
	
	public void setReimBType(String reimBType) {
		this.reimBType = reimBType;
	}	
}

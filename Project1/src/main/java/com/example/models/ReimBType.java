package com.example.models;

enum Type {
	LODGING, TRAVEL, FOOD, OTHER;
}
public class ReimBType {
	private Type reimBType;

	public Type getReimBtype() {
		return reimBType;
	}

	public void setReimBtype(int reimBId) {
		switch(reimBId) {
		case 1:
			this.reimBType = Type.LODGING;
			break;
		case 2:
			this.reimBType = Type.TRAVEL;
			break;
		case 3:
			this.reimBType = Type.FOOD;
			break;
		case 4:
			this.reimBType = Type.OTHER;
			break;
		}
	}
	
	public void printReimBType() {
		if (reimBType!=null) {
			switch (reimBType) {
				case LODGING: {
					System.out.println("Reimburstment type is Lodging");
					break;
				}
				case TRAVEL: {
					System.out.println("Reimburstment type is Travel");
					break;
				}
				case FOOD: {
					System.out.println("Reimburstment type is Food");
					break;
				}
				case OTHER: {
					System.out.println("Reimburstment type is Other");
					break;
				}
			}
		}
		else {
			System.out.println("This Reimburstment type is NULL.");
		}
		
	}
	
	
}

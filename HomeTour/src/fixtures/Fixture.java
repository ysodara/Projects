package fixtures;

public abstract class Fixture {
	String name;
	String shortDescription;
	String longDescription;
	
	Fixture(){}
	
	Fixture(String name){
		this.name = name;
	}
	
	Fixture(String name, String shortDescription){
		this.name = name;
		this.shortDescription = shortDescription;
	}
	
	Fixture(String name, String shortDescription, String longDescription){
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}
	public String getName() {
		return this.name;
	}
	public String getShortDescription() {
		return this.shortDescription;
	}
	public String getLongDescription() {
		return this.longDescription;
	}
	
}

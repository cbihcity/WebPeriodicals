package by.pvt.heldyieu.enums;

public enum UserType {

	ADMIN("ADMIN"),
	USER("USER");

	
	private String value;
	UserType(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}

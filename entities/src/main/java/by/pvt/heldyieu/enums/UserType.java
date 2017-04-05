package by.pvt.heldyieu.enums;

public enum UserType {
<<<<<<< HEAD
	ADMIN("ADMIN"),
	USER("USER");
=======
	ADMIN("1"),
	USER("2");
>>>>>>> origin/master
	
	private String value;
	UserType(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}

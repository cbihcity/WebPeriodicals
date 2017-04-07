package by.pvt.heldyieu;

import by.pvt.heldyieu.interfaces.Constants;

import java.util.ResourceBundle;

public class ResourceManager implements Constants {
	private ResourceBundle resourceBundle;
	
	public ResourceManager(String resource) {
		super();
		this.resourceBundle = ResourceBundle.getBundle(resource);
	}
	
	public String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}

package by.pvt.heldyieu;

import java.util.ResourceBundle;
import by.pvt.heldyieu.interfaces.Constants;

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

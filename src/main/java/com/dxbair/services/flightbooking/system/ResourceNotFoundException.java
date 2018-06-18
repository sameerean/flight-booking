package com.dxbair.services.flightbooking.system;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5962898215276911029L;

	public ResourceNotFoundException(String resourceType, String keyName, String keyValue) {
		super(resourceType + " with " + keyName + "[" + keyValue + "] not found in the system!");
	}

}

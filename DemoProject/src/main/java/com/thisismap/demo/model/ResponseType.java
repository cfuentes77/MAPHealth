package com.thisismap.demo.model;

/**
 * Class <tt>ResponseType</tt>
 */
public enum ResponseType {
    ERROR("ERROR"),
    SUCCESS("SUCCESS"),
    NOT_LOGGED_IN("NOT_LOGGED_IN"),
    ACCESS_DENIED("ACCESS_DENIED");

    private String type;
    
    private ResponseType(String type) {
        this.setType(type);
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

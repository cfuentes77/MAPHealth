package com.thisismap.demo.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class <tt>APIRequest</tt>
 */
public class ApiRequest implements Serializable {

	private static final long serialVersionUID = 2525307163037092016L;
	
	private String publicKey;
    private String authToken;
    private String dataType = null;
    private Map<String, Object> requestObject;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Map<String, Object> getRequestObject() {
        if (requestObject == null) {
            requestObject = new HashMap<String, Object>();
        }
        return requestObject;
    }

    public void setRequestObject(Map<String, Object> requestObject) {
        this.requestObject = requestObject;
    }
}

package com.hmpo.hmdemo.datamodel;
import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonGetter;

public class KeyCloakState {
	
	private Integer statusId;

	private String userId;
	
	private String message;

	public KeyCloakState() {
	
	}
	
	@JsonGetter("statusId")
	public Integer getstatusId() {
		return statusId;
	}

	public void setstatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	@JsonGetter("userId")
	public String getuserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonGetter("message")
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}


}

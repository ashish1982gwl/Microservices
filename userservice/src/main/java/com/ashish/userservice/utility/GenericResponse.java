package com.ashish.userservice.utility;

import java.io.Serializable;

public class GenericResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "GenericResponse [status=" + status + ", errorDescription=" + errorDescription + ", errorCode="
				+ errorCode + ", userDisplayMesg=" + userDisplayMesg + ", Data=" + Data + "]";
	}
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getUserDisplayMesg() {
		return userDisplayMesg;
	}
	public void setUserDisplayMesg(String userDisplayMesg) {
		this.userDisplayMesg = userDisplayMesg;
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	private String errorDescription;
	private String errorCode;
	private String userDisplayMesg;
	private Object Data;
	private Integer statusCode;
	
	
public GenericResponse() {
		
	}
	
	public GenericResponse(Integer statusCode, String message) {
		this.statusCode = statusCode;
		this.userDisplayMesg = message;
	}
}

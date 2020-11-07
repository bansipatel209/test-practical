package com.exception;

import org.springframework.http.HttpStatus;

public class ResonseBean {

	private HttpStatus errorCode;
	private String message;
	private boolean status;
	
	public ResonseBean(HttpStatus errorCode, String message, boolean status) {
		this.errorCode = errorCode;
		this.message = message;
		this.status = status;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

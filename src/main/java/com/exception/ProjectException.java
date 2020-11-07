package com.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class ProjectException extends Exception{

	private HttpStatus httpStatus;
	private Exception exception = null;
	private String message = null;

	public ProjectException(HttpStatus httpStatus, Exception exception) {
		this.httpStatus = httpStatus;
		this.exception = exception;
	}

	public ProjectException(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public ProjectException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public Exception getException() {
		return exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ProjectException(Throwable throwable) {
		super(throwable);
	}

	@Override
	public String toString() {
		return "ProjectException [httpStatus=" + httpStatus + ", exception=" + exception + ", message=" + message + "]";
	}

}

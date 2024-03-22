package com.insuranceapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	
	
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private HttpStatus status;
    
    public ApiErrors() {
    	
    }
    
	public ApiErrors(LocalDateTime timestamp, int statusCode, String error, HttpStatus status) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.error = error;
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ApiErrors [timestamp=" + timestamp + ", statusCode=" + statusCode + ", error=" + error + ", status="
				+ status + "]";
	}
    
    
}

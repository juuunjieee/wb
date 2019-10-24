package com.ulwx.service;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 8164708610922822091L;

	public ServiceException() {
		super();
	}

	public ServiceException(Throwable cause) {
		super(cause);
	} 

	public ServiceException(String msg,Throwable cause) {
		super(msg,cause);
	}
	
	public ServiceException(String msg) {
		super(msg);
	}

}

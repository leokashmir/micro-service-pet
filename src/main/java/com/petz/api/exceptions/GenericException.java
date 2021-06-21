package com.petz.api.exceptions;

public class GenericException extends Exception {
	

	private static final long serialVersionUID = -7082212867266961646L;
	private final String msg;

	public GenericException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	
	
	
}

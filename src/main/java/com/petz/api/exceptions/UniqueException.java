package com.petz.api.exceptions;

public class UniqueException extends Exception {
	
	
	private static final long serialVersionUID = -8423302345212463478L;
	private final String msg;

	public UniqueException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	
	
	

}

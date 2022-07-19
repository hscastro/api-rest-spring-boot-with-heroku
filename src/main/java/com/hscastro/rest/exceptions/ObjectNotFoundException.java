package com.hscastro.rest.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6799426349008895343L;
	
	private String msg;

	public ObjectNotFoundException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	
}

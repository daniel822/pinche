package com.pinche.vo;

public class Failure extends Response {

    private String message;

    public Failure(int code ,String msg){
    	this.setStatus(code);
        this.message = msg;
    }

    public Failure(String msg){
    	this.setStatus(1);
        this.message = msg;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

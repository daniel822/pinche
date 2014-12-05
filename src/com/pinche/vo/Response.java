package com.pinche.vo;

import java.util.HashMap;

public class Response {

	private int status = 0;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static Success success() {
		return new Success(new HashMap<>());
	}

	public static Success success(Object data) {
		return new Success(data);
	}

	public static Failure fail(String msg) {
		return fail(1, msg);
	}

	public static Failure fail(int code, String msg) {
		return new Failure(code, msg);
	}

}

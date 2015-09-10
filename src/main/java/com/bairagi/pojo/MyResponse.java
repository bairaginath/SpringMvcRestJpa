package com.bairagi.pojo;

public class MyResponse {
	
	
	private String message;
	private String code;
	private String type;
	private String field;
	
	public MyResponse(){
		
	}
	
	
	
	public MyResponse(String message, String code, String type, String field) {
		super();
		this.message = message;
		this.code = code;
		this.type = type;
		this.field = field;
	}



	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

}

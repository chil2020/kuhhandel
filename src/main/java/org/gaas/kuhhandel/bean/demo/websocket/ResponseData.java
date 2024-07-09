
package org.gaas.kuhhandel.bean.demo.websocket;

public class ResponseData {
	private String code;
	private String message;
	private Object data;
	
	public ResponseData() {
		super();
	}
	
	public ResponseData(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public static ResponseData error(String message) {
		ResponseData responseData = new ResponseData();
		responseData.setCode("500");
		responseData.setMessage(message);
		return responseData;
	}

	public static ResponseData ok(Object data) {
		ResponseData responseData = new ResponseData();
		responseData.setCode("200");
		responseData.setMessage("Success");
		responseData.setData(data);
		return responseData;
	}

}

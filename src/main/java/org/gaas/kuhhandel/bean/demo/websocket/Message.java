package org.gaas.kuhhandel.bean.demo.websocket;

import lombok.Data;

@Data
public class Message {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

}

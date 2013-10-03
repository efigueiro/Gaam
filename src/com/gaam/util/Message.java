package com.gaam.util;

import java.io.Serializable;

/**
 * This class is for model a message object to show system messages like error
 * or warnings messages. this class use message.jsp
 * 
 * @author everson.figueiro
 * 
 */

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String text;

	public Message() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

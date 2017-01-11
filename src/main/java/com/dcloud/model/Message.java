package com.dcloud.model;

public class Message {

	private int id;

	private String content;

	private String sender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String toString() {
		return String.valueOf(id) + "\t" + content + "\t " + sender;
	}
}

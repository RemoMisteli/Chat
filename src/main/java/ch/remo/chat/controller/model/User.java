package ch.remo.chat.controller.model;

import java.util.List;

public class User {
	private Long id;
	private String username;
	private String password;

	private List<Message> sendedMessages;
	private List<Message> receivedMessages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String users) {
		this.username = users;
	}

	public String getPassword() {
		return password;

	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Message> getSendedMessages() {
		return sendedMessages;
	}

	public void setSendedMessages(List<Message> sendedMessages) {
		this.sendedMessages = sendedMessages;
	}

	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

}

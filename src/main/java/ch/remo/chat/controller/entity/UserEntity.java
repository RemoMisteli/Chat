package ch.remo.chat.controller.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany; 


@Entity(name = "users")
public class UserEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username")
	private String user;
	@Column(name = "password")
	private String password;
	@ManyToMany
    @JoinTable(name = "users_messages", 
      joinColumns = @JoinColumn( name = "sender", referencedColumnName = "id" ),
      inverseJoinColumns = @JoinColumn( name = "message", referencedColumnName = "id" )
    )
	private List<MessageEntity> sentMessages;
	
	@ManyToMany
    @JoinTable(name = "users_messages", 
      joinColumns = @JoinColumn( name = "receiver", referencedColumnName = "id" ),
      inverseJoinColumns = @JoinColumn( name = "message", referencedColumnName = "id" )
    )
	private List<MessageEntity> receivedMessages;
	
	public List<MessageEntity> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<MessageEntity> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public List<MessageEntity> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<MessageEntity> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

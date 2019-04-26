package ch.remo.chat.controller.model;

public class User {
	private Long id;
	private String user;
	private String password;
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String users) {
		this.user = users;
	}
	public String getPassword() {
		return password;
		
	}
	public void setPassword(String password) {
		this.password=password;
	}
	

}

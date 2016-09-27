package com.niit.CollaborationBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Friend")
@Component
public class Friend {

	@Id
	private String id;
	private String userId;
	private String friendId;
	private char status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char c) {
		this.status = c;
	}
	
	
	
}

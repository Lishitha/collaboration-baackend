package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Friend;

public interface FriendDAO {

	public List<Friend> list();
	public Friend get(String id);
	public boolean saveOrUpdate(Friend friend);
	public boolean delete(String id);
	
}

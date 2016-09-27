package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.UserDetail;

public interface UserDetailDAO {

	public List<UserDetail> list();
	//public UserDetails get(String id,String passWord);
	public UserDetail get(String id);
	public boolean saveOrUpdate(UserDetail userDetail);
	//public boolean update(UserDetails userdetails);
	public boolean delete(String id);
	//public UserDetail isValidUserDetails(String id,String name);
	
}

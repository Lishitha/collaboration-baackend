package com.niit.CollaborationBackEnd.TestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.FriendDAO;
import com.niit.CollaborationBackEnd.model.Friend;

public class FriendTestCase {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		
		FriendDAO friendDAO = (FriendDAO) context.getBean("friendDAO");
		Friend friend = (Friend) context.getBean("friend");
		
		friend.setId("01");
		friend.setUserId("US01");
		friend.setFriendId("FR01");
		friend.setStatus('N');
		
		friendDAO.saveOrUpdate(friend);

	}

}

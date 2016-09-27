package com.niit.CollaborationBackEnd.TestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.UserDetailDAO;
import com.niit.CollaborationBackEnd.model.UserDetail;



public class UserDetailTestCase {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		
		UserDetailDAO userDetailDAO = (UserDetailDAO) context.getBean("userDetailDAO");
		UserDetail userDetail = (UserDetail) context.getBean("userDetail");
		
		userDetail.setId("US01");
		userDetail.setName("KUTTU");
		userDetail.seteMail("kuttu@gmail.com");
		userDetail.setPassWord("KUTTU");
		userDetail.setAddress("CALICUT");
		userDetail.setMobNumber("9946161784");
		
		userDetailDAO.saveOrUpdate(userDetail);

		/*UserDetailDAO userDetailDAO = (UserDetailDAO) context.getBean("userDetailDAO");
		UserDetail userDetail = (UserDetail) context.getBean("userDetail");

		userDetail.setId("US01");
		userDetail.setName("KUTTU");
		userDetail.seteMail("kuttu@gmail.com");
		userDetail.setPassWord("KUTTU");
		userDetail.setAddress("CALICUT");
		userDetail.setMobNumber("9946161784");

		userDetailDAO.saveOrUpdate(userDetail);*/
	}
}

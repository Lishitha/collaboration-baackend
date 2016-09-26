/*package com.niit.CollaborationBackEnd.JUnitTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.BlogDAO;
import com.niit.CollaborationBackEnd.model.Blog;

public class BlogTest {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Blog blog;
	
	@Autowired
	private static BlogDAO blogDAO;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		blog = (Blog) context.getBean("blog");
		blogDAO = (BlogDAO) context.getBean("blogDAO");
		
	}
	
	@Test
	public void blogCreateTestCase()
	{
		blog.setId("BL1");
		blog.setDescription("This is blog 1");
		blog.setUserId("US1");
		blog.setStatus('N');
	}
	
	
	

}*/


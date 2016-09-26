package com.niit.CollaborationBackEnd.TestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.BlogDAO;
import com.niit.CollaborationBackEnd.model.Blog;

public class BlogTestCase {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd.TestCase");
		context.refresh();
		BlogDAO blogDAO= (BlogDAO) context.getBean("blogDAO");
		Blog blog = (Blog) context.getBean("blog");
		
		blog.setId("BL01");
		blog.setDescription("This is blog 1 ");
		blog.setUserId("US01");
		blog.setStatus('N');
		
		blogDAO.saveOrUpdate(blog);

	}

}

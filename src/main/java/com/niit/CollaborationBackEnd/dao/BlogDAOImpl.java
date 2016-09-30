package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Blog blog;

	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		try 
		{
			this.sessionFactory=sessionFactory;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Transactional
	public List<Blog> list()
	{
		String hql = "from Blog" ;
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Blog> list = query.list();
		
		return list;
	}
	@Transactional
	public boolean save(Blog blog) {
	
		
		try {
			sessionFactory.getCurrentSession().save(blog);
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	
		return true;
	}


	@Transactional
	public boolean update(Blog blog) {

		try {
			sessionFactory.getCurrentSession().update(blog);
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	
		return true;
	}

	
	@Transactional
	public Blog get(String id)
	{
		String hql = "from Blogs where id=" + "'" + id + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = query.list();
		
		if(list !=null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
	
	@Transactional
	public boolean delete(String id)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}

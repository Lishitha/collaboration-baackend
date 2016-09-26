package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.CollaborationBackEnd.model.Blog;

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
	public boolean saveOrUpdate(Blog userdetails)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
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
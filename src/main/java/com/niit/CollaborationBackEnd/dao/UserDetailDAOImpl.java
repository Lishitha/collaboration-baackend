package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.CollaborationBackEnd.model.UserDetail;

public class UserDetailDAOImpl implements UserDetailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserDetail userDetails;
	
	public UserDetailDAOImpl(SessionFactory sessionFactory)
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
	public List<UserDetail> list()
	{
		String hql = "from UserDetail" ;
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetail> list = query.list();
		
		return list;
	}
	
	@Transactional
	public boolean saveOrUpdate(UserDetail userdetails)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public UserDetail get(String id)
	{
		String hql = "from UserDetails where id=" + "'" + id + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetail> list = query.list();
		
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
			sessionFactory.getCurrentSession().delete(userDetails);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}

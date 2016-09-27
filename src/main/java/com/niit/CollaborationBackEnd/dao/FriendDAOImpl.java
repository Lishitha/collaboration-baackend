package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.model.Friend;

@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Friend friend;

	public FriendDAOImpl(SessionFactory sessionFactory)
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
	public List<Friend> list()
	{
		String hql = "from Friend" ;
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Friend> list = query.list();
		
		return list;
	}
	
	@Transactional
	public boolean saveOrUpdate(Friend friend)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public Friend get(String id)
	{
		String hql = "from Friends where id=" + "'" + id + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> list = query.list();
		
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
			sessionFactory.getCurrentSession().delete(friend);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}

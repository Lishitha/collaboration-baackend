package com.niit.CollaborationBackEnd.dao;

import java.util.List;
import com.niit.CollaborationBackEnd.model.Event;

public interface EventDAO {
	
	public List<Event> list();
	public Event get(String id);
	public boolean saveOrUpdate(Event event);
	public boolean delete(String id);

}

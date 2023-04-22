package com.sf.srs.Dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.srs.Bean.CredentialsBean;
import com.sf.srs.Bean.RouteBean;
import com.sf.srs.Bean.ScheduleBean;
import com.sf.srs.Bean.ShipBean;



@Repository
public class AdministratorDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<ShipBean>q;
	private Query<ScheduleBean>q1;
	private Query<RouteBean>q2;
	
	public String addShip(ShipBean shipbean) 
	{
		if(shipbean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(shipbean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(shipbean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	
	public String updateShip(ShipBean shipbean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(shipbean!=null)
		{
		session.update(shipbean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(shipbean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	public String deleteShip(int shipID)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(shipID>=0)
		{
		Query q=session.createQuery("delete from ShipBean where shipID=:sid");
		q.setParameter("sid", shipID);
		q.executeUpdate();
transaction.commit();
session.close();
		return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}
	}
	
//	public String updateShipById(int shipID)
//	{
//		ShipBean elBean =new ShipBean();
//		session=sessionFactory.openSession();
//		transaction=session.beginTransaction();
//		Query<ShipBean> q=session.createQuery("from ShipBean where shipID=:sid");
//		if(shipID>=0)
//		{
//			
//			session.update(shipbean);
//
//			transaction.commit();
//
//			session.close();
//		return "SUCCESS";
//		}
//		else
//		{
//			return "FAIL";
//		}
//	}
	public ArrayList<ShipBean> viewShips()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from ShipBean");
		return (ArrayList<ShipBean>) q.list();
	}
	public ShipBean viewShipByid(int shipID)
	{
		ShipBean elBean =new ShipBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<ShipBean> q=session.createQuery("from ShipBean where shipID=:sid");
	q.setParameter("sid", shipID);
	ArrayList<ShipBean> all=(ArrayList<ShipBean>) q.getResultList();
	for(ShipBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}
	
	
	
	
	public String addSchedule(ScheduleBean schedulebean) 
	{
		ShipBean sb=viewShipByid(schedulebean.getShipBean().getShipID());
		RouteBean rb=viewRouteByid(schedulebean.getRouteBean().getRouteID());
		schedulebean.setRouteBean(rb);
		schedulebean.setShipBean(sb);
		if(schedulebean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(schedulebean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(schedulebean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	
	public String updateSchedule(ScheduleBean schedulebean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(schedulebean!=null)
		{
		session.update(schedulebean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(schedulebean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	public String deleteSchedule(int ScheduleId)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(ScheduleId>=0)
		{
		Query q1=session.createQuery("delete from ScheduleBean where scheduleID=:scid");
		q1.setParameter("scid", ScheduleId);
		q1.executeUpdate();
transaction.commit();
session.close();
		return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}
	}
	
	public ArrayList<ScheduleBean> viewSchedules() {
	    session = sessionFactory.openSession();
	    transaction = session.beginTransaction();
	    q1 = session.createQuery("from ScheduleBean"); // Initialize q1 object
	    return (ArrayList<ScheduleBean>) q1.list();
	}
	
	
	public ScheduleBean viewScheduleByid(int scheduleID)
	{
		ScheduleBean s1Bean=new ScheduleBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<ScheduleBean> q1=session.createQuery("from ScheduleBean where scheduleID=:scid");
	q1.setParameter("scid", scheduleID);
	ArrayList<ScheduleBean> all=(ArrayList<ScheduleBean>) q1.getResultList();
	for(ScheduleBean e2:all)
	{
		s1Bean=e2;
	}
	return s1Bean;
	}
	
	
	
	
	public String addRoute(RouteBean routebean) 
	{
		ShipBean sb=viewShipByid(routebean.getShipBean().getShipID());
		System.out.println(sb);
		routebean.setShipBean(sb);
	
		if(routebean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(routebean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(routebean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	
	public String updateRoute(RouteBean routebean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(routebean!=null)
		{
		session.update(routebean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(routebean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	public String deleteRoute(int RouteId)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(RouteId>=0)
		{
		Query q2=session.createQuery("delete from RouteBean where RouteID=:rid");
		q2.setParameter("rid", RouteId);
		q2.executeUpdate();
transaction.commit();
session.close();
		return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}
	}
	public ArrayList<RouteBean> viewRoutes()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q2=session.createQuery("from RouteBean");
		return (ArrayList<RouteBean>) q2.list();
	}
	public RouteBean viewRouteByid(int routeid)
	{
		RouteBean rBean=new RouteBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<RouteBean> q2=session.createQuery("from RouteBean where routeID=:rid");
	q2.setParameter("rid", routeid);
	ArrayList<RouteBean> all=(ArrayList<RouteBean>) q2.getResultList();
	for(RouteBean e3:all)
	{
		rBean=e3;
	}
	return rBean;
	}
	
//	public boolean authenticate(CredentialsBean credentialsbean)  throws Exception
//	{
//    	Transaction transaction = null;
//	    try (Session session = sessionFactory.openSession()) {
//	    	transaction=session.beginTransaction();
//	    	Query q=session.createQuery("from CredentialsBean where userId=:uid and password=:pwd");
//	    	q.setParameter("uid", credentialsbean.getUserId());
//	    	q.setParameter("pwd",credentialsbean.getPassword());
//	    	
//	    	ArrayList<CredentialsBean> al=(ArrayList<CredentialsBean>) q.getResultList();
//	    	int count=0;
//	    	for(CredentialsBean uc:al)
//	    	{
//				if((uc.getUserId().equals(credentialsbean.getUserId()))&&(uc.getPassword().equals(credentialsbean.getPassword())))
//				{
//					count++;
//					if(count>0)
//					{
//						return true;
//					}
//					
//					else
//					{
//						return false;
//					}
//				}
//	    	}
//	    	return false;
//	 
//	    } catch (Exception e) {
//	        if (transaction != null) {
//	            transaction.rollback();
//	        }
//	        throw new Exception("Error authenticating user with ID: " + credentialsbean.getUserId() + " in the repository layer", e);
//	    }
//	}
	
	public boolean authenticate(CredentialsBean user) 
	{
	    System.out.println("Under Dao "+user.getUserId()+" "+user.getPassword());
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    Query q3=session.createQuery("from CredentialsBean where userId=:uid and password=:pss");
	    q3.setParameter("uid", user.getUserId());
	    q3.setParameter("pss", user.getPassword());
	    ArrayList<CredentialsBean> al=(ArrayList<CredentialsBean>) q3.getResultList();
	    int count=0;
	    for(CredentialsBean cb:al)
	    {
	        if((cb.getUserId().equals(user.getUserId()))&&(cb.getPassword().equals(user.getPassword())))
	        {
	            System.out.println("Record is  present"+cb.getUserId()+" "+cb.getPassword());
	            count++;
	            if(count>0)
	            {
	    return true;
	            }
	            else
	            {
	                return false;
	            }
	        }
	    }
	    return false;
	    
	}
	
	public CredentialsBean viewcredentialsById(String userId) {
		
		CredentialsBean elBean=new CredentialsBean();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
		Query<CredentialsBean> q2=session.createQuery("from CredentialsBean where userId=:userId");
		q2.setParameter("userId", userId);
		ArrayList<CredentialsBean> all=(ArrayList<CredentialsBean>) q2.getResultList();
		for( CredentialsBean e1:all)
		{
			elBean=e1;
		}
		return elBean;
		}
	
}
	

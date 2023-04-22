package com.sf.srs.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.srs.Bean.PassengerBean;
import com.sf.srs.Bean.ProfileBean;
import com.sf.srs.Bean.ReservationBean;



@Repository
public class CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<ProfileBean>q4;
	private Query<ReservationBean>q5;
	private Query<PassengerBean>q6;
	
//	public String addProfile(ProfileBean profilebean) 
//	{
//		if(profilebean!=null)
//		{
//			session=sessionFactory.openSession();
//			transaction=session.beginTransaction();
//			session.save(profilebean);
//			transaction.commit();
//			session.close();
//			return "SUCCESS";
//		}
//		else if(profilebean==null)
//		{
//			return "ERROR";
//		}
//		else
//		{
//			return "FAIL";
//		}
//	}
	
	public String addProfile(ProfileBean profileBean ) {
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    session.save(profileBean);
	    transaction.commit();
	    session.close();
	    return "SUCCESS";
	}
	
	public String updateprofile(ProfileBean profilebean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(profilebean!=null)
		{
		session.update(profilebean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(profilebean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	
	public ArrayList<ProfileBean> viewprofiles()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q4=session.createQuery("from ProfileBean");
		return (ArrayList<ProfileBean>) q4.list();
	}
	public String deleteProfile(int userid) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	System.out.println(userid);
		if(userid>=0){
		 q4 =session.createQuery("delete from ProfileBean where userid=:uid");
			q4.setParameter("uid", userid);
			q4.executeUpdate();
			transaction.commit();
			session.close();
			return "Deleted successfully";
		}
		else {
			return "Fail";
		}
	}
	public ProfileBean viewuserbyid(int userid) {
		System.out.println(userid);
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query<ProfileBean>q1=session.createQuery("from ProfileBean where userid=:uid");
		q4.setParameter("uid",userid);
		ProfileBean s1=new ProfileBean();
		
List<ProfileBean> all= q4.getResultList();
for(ProfileBean sp:all)
{
	s1=sp;
}
return s1;
	}

	
	
	
	
	
	public String addReservation(ReservationBean reservationbean) 
	{
		if(reservationbean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(reservationbean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(reservationbean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	
	public String updateprofile(ReservationBean reservationbean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(reservationbean!=null)
		{
		session.update(reservationbean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(reservationbean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	
	public ArrayList<ReservationBean> viewReservations()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q5=session.createQuery("from ReservationBean");
		return (ArrayList<ReservationBean>) q5.list();
	}
	
	public String deleteReservation(int reservationid) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	System.out.println(reservationid);
		if(reservationid>=0){
		 q5 =session.createQuery("delete from ReservationBean where reservationid=:rid");
			q5.setParameter("rid", reservationid);
			q5.executeUpdate();
			transaction.commit();
			session.close();
			return "Deleted successfully";
		}
		else {
			return "Fail";
		}
	}
	public ReservationBean viewReservationbyid(int reservationid) {
		System.out.println(reservationid);
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query<ReservationBean>q1=session.createQuery("from ReservationBean where reservationid=:rid");
		q5.setParameter("rid",reservationid);
		ReservationBean s1=new ReservationBean();
		
List<ReservationBean> all= q5.getResultList();
for(ReservationBean sp:all)
{
	s1=sp;
}
return s1;
	}

	

	public String addPassenger(PassengerBean passengerbean) 
	{
		if(passengerbean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(passengerbean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(passengerbean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	public ArrayList<PassengerBean> viewPassengers()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q6=session.createQuery("from PassengerBean");
		return (ArrayList<PassengerBean>) q6.list();
	}
	
	
}

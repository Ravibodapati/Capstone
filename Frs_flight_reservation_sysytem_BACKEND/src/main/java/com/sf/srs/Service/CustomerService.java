package com.sf.srs.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.srs.Bean.PassengerBean;
import com.sf.srs.Bean.ProfileBean;
import com.sf.srs.Bean.ReservationBean;
import com.sf.srs.Dao.CustomerDao;

@Service
public   class CustomerService  {
	@Autowired
	private CustomerDao cdao;
	public String addProfile(ProfileBean profilebean)
	{
		return
	cdao.addProfile(profilebean);
	}
	public ArrayList<ProfileBean>
	viewProfile()
	{
		return cdao.viewprofiles();
	}
	public String
	updateProfile(ProfileBean Profilebean)
	{
		return
				cdao.updateprofile(Profilebean);
	}
	public ProfileBean viewuserbyid(int userid) {
		return cdao.viewuserbyid(userid);
	}
	public String deleteProfile(int userid) {
		return cdao.deleteProfile(userid);
	}
	
	
	
	public String addReservation(ReservationBean reservationbean)
	{
		return
	cdao.addReservation(reservationbean);
	}
	public ArrayList<ReservationBean>
	viewReservation()
	{
		return cdao.viewReservations();
	}
	public String
	updateReservation(ReservationBean reservationbean)
	{
		return
				cdao.updateprofile(reservationbean);
	}
	public ReservationBean viewReservationbyid(int reservationid) {
		return cdao.viewReservationbyid(reservationid);
	}
	public String deleteReservation(int reservationid) {
		return cdao.deleteReservation(reservationid);
	}
	
	
	public String addPassenger(PassengerBean passengerbean)
	{
		return
	cdao.addPassenger(passengerbean);
	}
	public ArrayList<PassengerBean>
	viewPassenger()
	{
		return cdao.viewPassengers();
	}
}
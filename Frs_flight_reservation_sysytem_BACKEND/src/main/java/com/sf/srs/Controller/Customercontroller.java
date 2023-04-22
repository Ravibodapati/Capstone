package com.sf.srs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.srs.Bean.PassengerBean;
import com.sf.srs.Bean.ProfileBean;
import com.sf.srs.Bean.ReservationBean;
import com.sf.srs.Service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/customer")
public class Customercontroller{
	@Autowired
	private CustomerService cuserv;
@PostMapping("/addProfile")
public String add(@RequestBody ProfileBean eb)
{
	cuserv.addProfile(eb);
	return "<h1>profile Added Successfully</h1>";
}
@GetMapping("/viewallAllprofiles")
public List<ProfileBean>viewall()
{
	
	return cuserv.viewProfile();
}
@PutMapping("/updateprofile")
public String update(@RequestBody ProfileBean eb)
{
	cuserv.updateProfile(eb);
	return "<h1>profile Updated successfully</h1>";
}
@GetMapping("/Profile/{id}")
public ProfileBean method2(@PathVariable("id") int userid) {
	return cuserv.viewuserbyid(userid);
}
@DeleteMapping("/deletep/{id}")
public String meth4(@PathVariable("id")int userid) {
	return cuserv.deleteProfile(userid);
}



@PostMapping("/addReservation")
public String add(@RequestBody ReservationBean eb)
{
	cuserv.addReservation(eb);
	return "<h1> Booked Successfully</h1>";
}
@GetMapping("/viewAllReservations")
public List<ReservationBean> viewalls()
{
	
	return cuserv.viewReservation();
}
@PutMapping("/updateReservation")
public String update(@RequestBody ReservationBean eb)
{
	cuserv.updateReservation(eb);
	return "<h1>Reservation Updated successfully</h1>";
}
@GetMapping("/reservation/{id}")
public ReservationBean method3(@PathVariable("id")int reservationid) {
	return cuserv.viewReservationbyid(reservationid);
}
@DeleteMapping("/deletere/{id}")
public String meth5(@PathVariable("id")int reservationid) {
	return cuserv.deleteReservation(reservationid);
}


@PostMapping("/addPasenger")
public String add(@RequestBody PassengerBean eb)
{
	cuserv.addPassenger(eb);
	return "<h1>  Passenger added Successfully</h1>";
}
@GetMapping("/viewAllPassengers")
public List<PassengerBean> viewallpassengers()
{
	
	return cuserv.viewPassenger();
}

}

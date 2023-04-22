package com.sf.srs.Bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SRS_TBL_Reservation")
public class ReservationBean {
	public int getReservationID() {
		return reservationID;
	}


	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public String getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getJourneyDate() {
		return journeyDate;
	}


	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}


	public int getNoOfSeats() {
		return noOfSeats;
	}


	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}


	public double getTotalFare() {
		return totalFare;
	}


	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}


	public int getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	
	public CredentialsBean getCredentialsbean() {
		return credentialsbean;
	}


	public void setCredentialsbean(CredentialsBean credentialsbean) {
		this.credentialsbean = credentialsbean;
	}


	public ScheduleBean getScheduleBean() {
		return scheduleBean;
	}


	public void setScheduleBean(ScheduleBean scheduleBean) {
		this.scheduleBean = scheduleBean;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int reservationID;
	@Column
	private String bookingDate;
	@Column
	private String journeyDate;
	@Column
	private int noOfSeats;
	@Column
	private double totalFare;
	@Column
	private int bookingStatus;
	
	@ManyToOne
	@JoinColumn(name = "fk_userID")
	private CredentialsBean credentialsbean;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_scheduleID")
	private ScheduleBean scheduleBean;


	public ReservationBean(int reservationID, String bookingDate, String journeyDate,
			int noOfSeats, double totalFare, int bookingStatus, CredentialsBean credentialsbean, ScheduleBean scheduleBean) {
		
		this.reservationID = reservationID;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
		this.bookingStatus = bookingStatus;
		this.credentialsbean = credentialsbean;
		this.scheduleBean = scheduleBean;
	}



	public ReservationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

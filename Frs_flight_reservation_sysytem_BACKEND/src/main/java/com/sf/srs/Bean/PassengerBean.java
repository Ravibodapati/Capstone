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
@Table(name="SRS_TBL_Passenger")

public class PassengerBean {
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}



	public ScheduleBean getSchedulebean() {
		return schedulebean;
	}


	public void setSchedulebean(ScheduleBean schedulebean) {
		this.schedulebean = schedulebean;
	}


	public ReservationBean getReservationBean() {
		return reservationBean;
	}


	public void setReservationBean(ReservationBean reservationBean) {
		this.reservationBean = reservationBean;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String gender;
	@Column
	private int age;


	@ManyToOne
	@JoinColumn(name = "reservationID")
	private ReservationBean reservationBean;
	
	@ManyToOne
	@JoinColumn(name = "scheduleID")
	private ScheduleBean schedulebean;


	public PassengerBean(int id, String name, String gender, int age, ReservationBean reservationBean,ScheduleBean schedulebean) {
		
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.reservationBean = reservationBean;
		this.schedulebean = schedulebean;
		
	}

	public PassengerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}


package com.sf.srs.Bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SRS_TBL_Route")
public class RouteBean {
	
	public int getRouteID() {
		return routeID;
	}
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getTravelduration() {
		return travelduration;
	}
	public void setTravelduration(String travelduration) {
		this.travelduration = travelduration;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	@Id
	@GeneratedValue
	@Column
	private int routeID;
	@Column
	private String source;
	@Column
	private String destination;
	@Column
	private String travelduration;
	@Column
	private double fare;
	
	
	public ShipBean getShipBean() {
		return shipBean;
	}
	public void setShipBean(ShipBean shipBean) {
		this.shipBean = shipBean;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_shipID")
	private ShipBean shipBean;
	
	
	public RouteBean(int routeID, String source, String destination, String travelduration, double fare,
			ShipBean shipBean) {
		super();
		this.routeID = routeID;
		this.source = source;
		this.destination = destination;
		this.travelduration = travelduration;
		this.fare = fare;
		this.shipBean = shipBean;
	}
	public RouteBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}

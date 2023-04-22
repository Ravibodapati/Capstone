package com.sf.srs.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SRS_TBL_Ship")

public class ShipBean {
	
	
	public int getShipID() {
		return shipID;
	}
	public void setShipID(int shipID) {
		this.shipID = shipID;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getReservationCapacity() {
		return reservationCapacity;
	}
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	@Id
	@GeneratedValue
	@Column
	private int shipID;
	@Column
	private String shipName;
	@Column
	private int seatingCapacity;
	@Column
	private int reservationCapacity;
	public ShipBean(int shipID, String shipName, int seatingCapacity, int reservationCapacity) {
		this.shipID = shipID;
		this.shipName = shipName;
		this.seatingCapacity = seatingCapacity;
		this.reservationCapacity = reservationCapacity;
	}
	public ShipBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ShipBean [shipID=" + shipID + ", shipName=" + shipName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity + "]";
	}
	
	

}


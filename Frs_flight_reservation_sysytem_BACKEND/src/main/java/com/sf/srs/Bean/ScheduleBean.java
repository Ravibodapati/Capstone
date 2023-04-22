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
@Table(name="SRS_TBL_Schedule")
public class ScheduleBean {
	
	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public ShipBean getShipBean() {
		return shipBean;
	}

	public void setShipBean(ShipBean shipBean) {
		this.shipBean = shipBean;
	}

	public RouteBean getRouteBean() {
		return routeBean;
	}

	public void setRouteBean(RouteBean routeBean) {
		this.routeBean = routeBean;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int scheduleID;
	@Column
	private String startDate;
	
	@ManyToOne
	@JoinColumn(name = "fk_shipID")
	private ShipBean shipBean;
	
	@ManyToOne
	@JoinColumn(name = "fk_routeID")
	private RouteBean routeBean;

	

	public ScheduleBean(int scheduleID, String startDate, ShipBean shipBean, RouteBean routeBean) {
		super();
		this.scheduleID = scheduleID;
		this.startDate = startDate;
		this.shipBean = shipBean;
		this.routeBean = routeBean;
	}

	public ScheduleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
package com.sf.srs.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.srs.Bean.CredentialsBean;
import com.sf.srs.Bean.RouteBean;
import com.sf.srs.Bean.ScheduleBean;
import com.sf.srs.Bean.ShipBean;
import com.sf.srs.Dao.AdministratorDao;

@Service

public   class AdministratorService  {
	@Autowired
	private AdministratorDao adao;
	public String addShip(ShipBean shipbean)
	{
		return
	adao.addShip(shipbean);
	}
	public ArrayList<ShipBean>
	viewShip()
	{
		return adao.viewShips();
	}
	public String
	updateShip(ShipBean shipbean)
	{
		return
				adao.updateShip(shipbean);
	}
	public String deleteShip( int shipID)
	{
		return
				adao.deleteShip(shipID);
	}
	public ShipBean
	viewShipById(int shipID)
	{
		return
				adao.viewShipByid(shipID);
}

//	public ShipBean
//	updateShipById(int shipID)
//	{
//		return
//				adao.updateShipById(shipID);
//} 
	
	
	
	public String addSchedule(ScheduleBean schedulebean)
	{
		return
	adao.addSchedule(schedulebean);
	}
	public ArrayList<ScheduleBean>
	viewSchedule()
	{
		return adao.viewSchedules();
	}
	public String
	updateSchedule(ScheduleBean schedulebean)
	{
		return
				adao.updateSchedule(schedulebean);
	}
	public String deleteSchedule( int scheduleid)
	{
		return
				adao.deleteSchedule(scheduleid);
	}
	public ScheduleBean
	viewScheduleById(int Scheduleid)
	{
		return
				adao.viewScheduleByid(Scheduleid);
}
	
	
	
	
	public String addRoute(RouteBean routebean)
	{
		return
	adao.addRoute(routebean);
	}
	public ArrayList<RouteBean>
	viewRoute()
	{
		return adao.viewRoutes();
	}
	public String
	updateRoute(RouteBean routebean)
	{
		return
				adao.updateRoute(routebean);
	}
	public String deleteRoute( int routeid)
	{
		return
				adao.deleteRoute(routeid);
	}
	public RouteBean
	viewRouteById(int routeid)
	{
		return
				adao.viewRouteByid(routeid);
}
	
//	public boolean authenticate(CredentialsBean credentialsbean) throws Exception {
//    	try {
//    		return adao.authenticate(credentialsbean);
//    	} catch (Exception e) {
//    	    throw new Exception("Error authenticating user with ID: " + credentialsbean.getUserId(), e);
//    	}
//    }

	public boolean authenticate(CredentialsBean user) {
        return adao.authenticate(user);
    }
    public CredentialsBean viewcredentialsById(String userId) {
    	return adao.viewcredentialsById(userId);
    }

}
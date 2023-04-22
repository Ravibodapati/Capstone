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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sf.srs.Bean.CredentialsBean;
import com.sf.srs.Bean.RouteBean;
import com.sf.srs.Bean.ScheduleBean;
import com.sf.srs.Bean.ShipBean;
import com.sf.srs.Service.AdministratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class Administratorcontroller {
	@Autowired
	private AdministratorService adserv;
@PostMapping("/addShip")
public String add(@RequestBody ShipBean eb)
{
	adserv.addShip(eb);
	return "<h1>Ship Added Successfully</h1>";
}
@GetMapping("/viewallShips")
public List<ShipBean> viewall()
{
	
	return adserv.viewShip();
}
@PutMapping("/updateShip")
public String update(@RequestBody ShipBean eb)
{
	adserv.updateShip(eb);
	return "<h1>Ship Updated successfully</h1>";
}
//@PutMapping("/updateShip/{id}")
//public String updateShipById(@PathVariable (value = "id") int shipID)
//{
//	return "<h1>"+adserv.updateShipById(shipID)+" record updated successfully</h1>";
//}

@GetMapping("/ship/{id}")
public ShipBean viewShipById(@PathVariable("id") int shipID) {
	
    return adserv.viewShipById(shipID);
}

@DeleteMapping("/deleteShip/{id}")
public String delete(@PathVariable (value = "id") int shipID)
{
	return "<h1>"+adserv.deleteShip(shipID)+" record deleted successfully</h1>";
}


@PostMapping("/addSchedule")
public String add(@RequestBody ScheduleBean eb)
{
	adserv.addSchedule(eb);
	return "<h1>Schedule Added Successfully</h1>";
}
@GetMapping("/AllSchedule")
public List<ScheduleBean> viewallschedule()
{
	
	return adserv.viewSchedule();
}
@PutMapping("/updateSchedule")
public String update(@RequestBody ScheduleBean eb)
{
	adserv.updateSchedule(eb);
	return "<h1>Schedule Updated successfully</h1>";
}
@GetMapping("/Schedule/{id}")
public ScheduleBean viewScheduleid(@PathVariable(value = "id") int Scheduleid)
{
	return adserv.viewScheduleById(Scheduleid);
	
}
@DeleteMapping("/deleteSchedule/{id}")
public String deleteSchedule(@PathVariable(value="id") int Scheduleid)
{
	return "<h1>"+adserv.deleteSchedule(Scheduleid)+" record deleted successfully</h1>";
}




@PostMapping("/addRoute")
public String add(@RequestBody RouteBean eb)
{
	adserv.addRoute(eb);
	return "<h1>Route Added Successfully</h1>";
}
@GetMapping("/AllRoute")
public List<RouteBean> viewallRoutes()
{
	
	return adserv.viewRoute();
}
@PutMapping("/updateRoute")
public String update(@RequestBody RouteBean eb)
{
	adserv.updateRoute(eb);
	return "<h1>Route Updated successfully</h1>";
}
@GetMapping("/Route/{id}")
public RouteBean viewRouteid(@PathVariable(value = "id") int Routeid)
{
	return adserv.viewRouteById(Routeid);
	
}
@DeleteMapping("/deleteRoute/{id}")
public String deleteRoute(@PathVariable(value="id") int Routeid)
{
	return "<h1>"+adserv.deleteRoute(Routeid)+" record deleted successfully</h1>";
}

//@GetMapping("/authenticateUser/{userID}/{password}")
//@ResponseBody
//public boolean authenticate(@PathVariable String userID,@PathVariable String password)
//{
//	try {
//		CredentialsBean credentialsbean=new CredentialsBean();
//		credentialsbean.setUserId(userID);
//		credentialsbean.setPassword(password);
//		return adserv.authenticate(credentialsbean);
//	} catch (Exception e) {
//        System.err.println("Error authenticating user: " + e.getMessage());
//        return false;
//    }
//}

@GetMapping("/selectUser/{userId}/{password}")
@ResponseBody
public boolean auth(@PathVariable String userId,@PathVariable String password)
{
    System.out.println("Under Controller "+userId+" "+password);
    CredentialsBean cb=new CredentialsBean();
    cb.setUserId(userId);
    cb.setPassword(password);
    System.out.println(adserv.authenticate(cb));;
    return adserv.authenticate(cb);

}
@GetMapping("/userbyid/{id}")
public CredentialsBean  viewuserById(@PathVariable(value = "id") String userId)
{
	
	return adserv. viewcredentialsById(userId);
}


}
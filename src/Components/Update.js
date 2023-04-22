import React, { useState ,useEffect} from 'react'
import { Service } from '../Service/Adminworker';
import {useNavigate,useParams} from 'react-router-dom'
import './CreateShip.css'
import axios from 'axios';

function Update() {

  const nav=useNavigate();

  const {shipID} = useParams(); 

  const[message,setMessage]=useState({
    shipName:"",seatingCapacity:"",reservationCapacity:""})

    const changeMessage=(e)=>{
        const newdata =  {...message};
        newdata[e.target.id] = e.target.value;
        setMessage(newdata);


const handleSubmit=(e)=>{

    e.preventDefault();
      

    if(customerId){
      Service.updateship(customerId,message).then((response)=>{
        
        nav('/')
        alert("Updated Sucessfully");
      })
    }else{
    Service.post(message);
    nav('/')
    alert("ship Created Sucessfully");
    }
   
  }



} 

useEffect(() => {
      
    Service.getShipById(shipID).then((response)=>{
      setMessage(
        {
          name: response.data.name,
          address:response.data.address,
          phone:response.data.phone,
          email:response.data.email,
          date_of_Birth:response.data.date_of_Birth,

      }
      )
    })
  }, [])

return (
    <div>
      <form onSubmit={handleSubmit} className='Container'>
        <div className='input-box'>
        <label className="details"for="name"><b>ShipName:</b></label>
      <input type="text" placeholder="Enter Ship Name" value={shipName}  onChange={(e)=>setShipName(e.target.value)} required="true"/><br/>
      
      </div>
      <div className='input-box'>
      <label className="details" for="Reservation_Capacity"><b>Reservation_Capacity:</b></label>
      <input type="text" placeholder="Enter Reservation_Capacity" value={reservationCapacity} onChange={(e)=>setReservationCapacity(e.target.value)} required="true"/><br/>
     </div>
      
      <div className='input-box'>
      <label className="details" for="Seating_Capacity"><b>Seating_Capacity:</b></label>
      <input type="text" placeholder="Enter Seating_Capacity" value={seatingCapacity} onChange={(e)=>setSeatingCapacity(e.target.value)} required="true" /><br/>
       </div >
      
      <button className='btn btn-primary' type="submit" >Sumbit</button>
      {/* {
        title1()
      } */}
      <button className='btn btn-danger'style={{marginLeft:"10px"}} onClick={(e)=>{nav('/Login')}}type="submit" >Cancel</button>
      </form>

      <hr/>
      
    </div>
  )
}

export default Update;

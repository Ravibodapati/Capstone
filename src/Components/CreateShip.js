import React, { useState ,useEffect} from 'react'
import { Service } from '../Service/Adminworker';
import {useNavigate} from 'react-router-dom'
import './CreateShip.css'

function CreateShip() {

  const nav=useNavigate();

const[shipName,setShipName]=useState('')
const[reservationCapacity,setReservationCapacity]=useState('')
const[seatingCapacity,setSeatingCapacity]=useState('')  
const handleSubmit=(e)=>{
const obj={shipName:shipName,seatingCapacity:seatingCapacity,reservationCapacity:reservationCapacity}
Service.post(obj);

nav('/Login')
      alert("Ship Created Sucessfully");
      console.log(obj)
} 

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
      
      <button className='btn btn-primary' type="submit" >Submit</button>
      
      <button className='btn btn-danger'style={{marginLeft:"10px"}} onClick={(e)=>{nav('/Login')}}type="submit" >Cancel</button>
      </form>

      <hr/>
      
    </div>
  )
}

export default CreateShip;
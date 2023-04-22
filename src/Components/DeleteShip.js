import React,{useEffect, useState} from 'react'
import { useNavigate,Link } from 'react-router-dom'
import {Service} from '../Service/Adminworker'
import './ViewShip.css';

function Deleteships() {
    const nav = useNavigate();
const [ship, setship]=useState([])

useEffect(() => {
  
    getships();
    
}, [])

const getships=async()=>{
    Service.getships().then ((response)=>{
        setship(response.data)
        
    })
}


const deleteship =async(shipID)=>{
   Service.deleteShip(shipID).then((response)=>{
    getships();
   })
}



  return (
    <div className='view_container' >
    {/* <Header
  buttonclassName="logout_button"
  buttonName="Logout"
  secondbuttonName="Add Flight"
  secondbuttonclassName="logout_button"
/> */}
<div className="shipList_table">
    <h2 className="view_heading">Delete List</h2>
        <button className='btn' onClick={()=>nav('/Login')} >Logout</button>
       
        

      <table align="center" className="shipTable"  >
        
            <thead className="table_heading_main">
                <tr className="table_row" >
                    <th className="table_heading">Ship Id</th>
                    <th className="table_heading">ShipName</th>
                    <th className="table_heading">Reservation_Capacity</th>
                    <th className="table_heading">Seating_Capacity</th>
                </tr>
                
            </thead>
            <tbody className="table_body">
                {
                    ship.map(
                        ship=>
                        <tr className="table_row" key={ship.shipID}>
                            <td className="table_data">{ship.shipID}</td>
                            <td className="table_data">{ship.shipName}</td>
                             <td className="table_data">{ship.reservationCapacity}</td>
                             <td className="table_data">{ship.seatingCapacity}</td>
                            <td>
                            <button className="btn btn-outline-danger" onClick={() => deleteship(ship.shipID)} style={{marginLeft:"10px"}}>Delete</button>
                            
                            
                            </td>
                        </tr>
                        
                    )
               }
            
            </tbody>
        </table>
        </div>  
    </div>
  )
}

export default Deleteships;
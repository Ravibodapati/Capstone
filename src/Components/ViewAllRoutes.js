import React,{useEffect, useState} from 'react'
import { useNavigate,Link, Route } from 'react-router-dom'
import {Service} from '../Service/Adminworker'
import './ViewShip.css';
function ViewallRoutes() {
    const nav = useNavigate();
const [route, setRoute]=useState([])

useEffect(() => {
  try{
    Service.getRoutes().then ((response)=>{
        setRoute(response.data)
        
    })
  }catch (error) {
    console.error(error);
  }
    
    
}, [])

// const getRoutes=async()=>{
    
// }

// const deleteRoute =async(routeID)=>{
//     Service.deleteRoute(routeID).then((response)=>{
//      getRoutes();
//     })
//  }

console.log(route)

  return (
    <div  className='view_container'>
    <div className="shipList_table">
        <h2 className="view_heading">View All Routes</h2>
        <button className='btn' onClick={()=>nav('/Login')} >Logout</button>
       
        

      <table align="center" className="shipTable"  >
        
            <thead className="table_heading_main">
                <tr className="table_row">
                    <th className="table_heading">Route Id</th>
                    <th className="table_heading">Destination</th>
                    <th className="table_heading">Source</th>
                    <th className="table_heading">Travel_Duration</th>
                    <th className="table_heading">Fare</th>
                    <th className="table_heading">Ship_Name</th>
                </tr>
                
            </thead>
            <tbody className="table_body">
                {
                    route.map(
                        route=>
                        <tr className="table_row" key={route.routeID}>
                            <td className="table_data">{route.routeID}</td>
                            <td className="table_data">{route.destination}</td>
                            <td className="table_data">{route.source}</td>
                             <td className="table_data">{route.travelduration}</td>
                             <td className="table_data">{route.fare}</td>
                             <td className="table_data">{route.shipBean.shipName}</td>
                            <td>
                             {/* <Link className="btn btn-outline-primary" to={`/edit-ship/${ship.shipID}`}>Edit</Link> */}
                            {/* <button className="btn btn-outline-danger" onClick={() => deleteRoute(route.routeID)} style={{marginLeft:"10px"}}>Delete</button> */}
                            {/* <button className="btn btn-outline-sucess" onClick={() => getBankById(customer.bank.bankid)} style={{marginLeft:"10px"}}>Bank Details</button> */}
                             
                            
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

export default ViewallRoutes;
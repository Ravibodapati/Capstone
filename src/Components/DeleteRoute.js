import React,{useEffect, useState} from 'react'
import { useNavigate,Link, Route } from 'react-router-dom'
import {Service} from '../Service/Adminworker'
import './ViewShip.css';
function DeleteRoute() {
    const nav = useNavigate();
const [route, setRoute]=useState([])

useEffect(() => {
  
    getRoutes();
    
}, [])

const getRoutes=async()=>{
    Service.getRoutes().then ((response)=>{
        setRoute(response.data)
        
    })
}

const deleteRoute =async(routeID)=>{
    Service.deleteRoute(routeID).then((response)=>{
     getRoutes();
    })
 }

console.log(route)

  return (
    <div  className='view_container'>
    <div className="shipList_table">
        <h2 className="view_heading">Delete Routes</h2>
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
                            <button className="btn btn-outline-danger" onClick={() => deleteRoute(route.routeID)} style={{marginLeft:"10px"}}>Delete</button>
                             
                            
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

export default DeleteRoute;

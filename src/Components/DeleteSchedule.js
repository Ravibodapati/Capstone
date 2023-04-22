import { useEffect,useState } from 'react'
import {Service} from '../Service/Adminworker'
import { useNavigate,Link } from 'react-router-dom'
import './ViewShip.css';
function DeleteSchedule() {
    const nav = useNavigate();
    const [schedule, setSchedule]=useState([])
    
    useEffect(() => {
      
        getschedules();
        
    }, [])
    
    const getschedules=async()=>{
        Service.getschedules().then ((response)=>{
            setSchedule(response.data)

        })
    }
const deleteschedule =async(scheduleID)=>{
    Service.deleteSchedule(scheduleID).then((response)=>{
     getschedules();
    })
 }

  return (
    <div  className='view_container'>
      
      <div className="shipList_table">
      <h2 className="view_heading">Delete Schedules</h2>
        <button className='btn' onClick={()=>nav('/Login')} >Logout</button>
       
        

      <table   align="center" className="shipTable" >
        
            <thead  className="table_heading_main">
                <tr className="table_row" >
                    <th className="table_heading">Schedule Id</th>
                    <th className="table_heading">Start_Date</th>
                    <th className="table_heading">Ship_Name</th>
                    <th className="table_heading">Destination</th>
                    <th className="table_heading">Source</th>
                    <th className="table_heading">Travel_Duration</th>
                    <th className="table_heading">Fare</th>
                  
                </tr>
                
            </thead>
            <tbody className="table_body">
                {
                    schedule.map(
                        schedule=>
                        <tr className="table_row" key={schedule.scheduleID}>
                            <td className="table_data">{schedule.scheduleID}</td>
                            <td className="table_data">{schedule.startDate}</td>
                            <td className="table_data">{schedule.shipBean.shipName}</td>
                            <td className="table_data">{schedule.routeBean.destination}</td>
                            <td className="table_data">{schedule.routeBean.source}</td>
                            <td className="table_data">{schedule.routeBean.travelduration}</td>
                            <td className="table_data">{schedule.routeBean.fare}</td>
                            <td>
                            <button className="btn btn-outline-danger" onClick={() => deleteschedule(schedule.scheduleID)} style={{marginLeft:"10px"}}>Delete</button> 
                            
                            
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

export default DeleteSchedule;
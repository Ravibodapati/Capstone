import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { Service } from '../Service/Adminworker'
import './CreateShip.css'
function CreateRoute() {
  const { routeID } = useParams();
  const{shipID} = useParams();

  const[shipName, setShipname]=useState("");

  const nav=useNavigate();

  
  const [data, setData] = useState({
    routeID: 0,
    source: "",
    destination: "",
    travelduration: "",
    fare: 0,
    shipBean: {
        shipID: 0,
        shipName: "",
        seatingCapacity: 0,
        reservationCapacity: 0
    }

  });
  const [shi, setShi] = useState([
    {
      shipName: "",
      shipID: 0,
      seatingCapacity: 0,
      reservationCapacity: 0
    }
  ])

  const changedata = (e) => {
    const newdata = { ...data };
    newdata[e.target.id] = e.target.value;
    setData(newdata);
  }

  

  const handleChangeCus = (e) => {
    const selectShip = shi.find(item => item.shipName === e.target.value);
    const newdata2 = { ...data };
    newdata2[e.target.id] = e.target.value;
    newdata2.shipBean.shipID = selectShip.shipID;
    newdata2.shipBean.shipName = selectShip.shipName; 
    
    setData(newdata2);
  }
  const handleSubmit =async(e)=>{
    e.preventDefault();
    Service.postRoute(data);
     
    alert(" Created Route Sucessfully");
    nav('/Login')

  }
console.log(data)
  useEffect(() => {

      const fetchdata = async () => {
        const resp = await Service.getships();
        setShi(resp.data);
    }
    

      fetchdata();
  
}, []);
  
  
  return (

    <div>
      
      <form onSubmit={handleSubmit} className='Container'>
        <div className='input-box'>
          <b><label >Ship_Name:</label></b>
          <select  Value={shipName} onChange={handleChangeCus} >
            <option >--Select Ship--</option>
            {
              shi.map((item) => {
                return <option value={item.shipName} key={item.shipID}>{item.shipName}</option>
              })
            }
          </select>
        </div>

        <div className='input-box'>
        <label className="details"for="source"><b>Source:</b></label>
      <input type="text" placeholder="Enter your Source" id="source"value={data.source}  onChange={(e)=>changedata(e)} required="true"/><br/>
      
      </div>
      <div className='input-box'>
      <label className="details" for="destination"><b>Destination:</b></label>
      <input type="text" placeholder="Enter your Destination" id="destination"value={data.destination} onChange={(e)=>changedata(e)} required="true"/><br/>
     </div>
      
      <div className='input-box'>
      <label className="details" for="Travel_Duration"><b>Travel_Duration:</b></label>
      <input type="text" placeholder="Enter your Trvael_Duration" id="travelduration" value={data.travelduration} onChange={(e)=>changedata(e)} required="true" /><br/>
       </div >

       <div className='input-box'>
      <label className="details" for="Travel_Duration"><b>Fare:</b></label>
      <input type="text" placeholder="Enter your Fare"id="fare" value={data.fare} onChange={(e)=>changedata(e)} required="true" /><br/>
       </div >
      
      <button className='btn btn-primary' type="submit" >Sumbit</button>
      
      <button className='btn btn-danger'style={{marginLeft:"10px"}} onClick={(e)=>{nav('/Login')}}type="submit" >Cancel</button>
      </form>

      <hr/>
      
    </div>
  )
}

export default CreateRoute;
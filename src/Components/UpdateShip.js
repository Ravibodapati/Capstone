import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

function UpdateShip() {

  const nav=useNavigate();

  const [ship, setShip] = useState({shipID:"", shipName: '', seatingCapacity: '', reservationCapacity: '' });
  
  const [message, setMessage] = useState('');

  function handleChange(event) {
    const { name, value } = event.target;
    setShip(prevShip => ({ ...prevShip, [name]: value }));
  }

  

  async function handleSubmit(event) {
    event.preventDefault();
    console.log(JSON.stringify(ship))
    try {
      const response = await axios.put("http://localhost:8080/admin/updateShip", ship).then(alert("ship is updated"));
      setMessage(response.data.message);
    } catch (error) {
      setMessage('Failed to update ship.');
    }
  }

  return (
    <div>
      <h2 className="text-center">Update Ship by ID</h2>
      {message && <p className="text-danger">{message}</p>}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="shipID">shipID:</label>
          <input
            type="text"
            className="form-control"
            id="shipID"
            name="shipID"
            value={ship.shipID}
            onChange={handleChange}
          />
        </div>            
        <div className="form-group">
          <label htmlFor="shipName">Ship Name:</label>
          <input
            type="text"
            className="form-control"
            id="shipName"
            name="shipName"
            value={ship.shipName}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="seatingCapacity">Seating Capacity:</label>
          <input
            type="number"
            className="form-control"
            id="seatingCapacity"
            name="seatingCapacity"
            value={ship.seatingCapacity}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="reservationCapacity">Reservation Capacity:</label>
          <input
            type="number"
            className="form-control"
            id="reservationCapacity"
            name="reservationCapacity"
            value={ship.reservationCapacity}
            onChange={handleChange}
          />
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
        <button className='btn btn-danger'style={{marginLeft:"10px"}} onClick={(e)=>{nav('/Login')}}type="submit" >Cancel</button>
      </form>
    </div>
  );
}

export default UpdateShip;
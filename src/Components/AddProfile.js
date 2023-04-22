import React, { useState } from "react";
import { Service } from '../Service/Adminworker'
import { useNavigate } from "react-router-dom";
import './CreateShip.css'

function Addprofile() {
  const navigate = useNavigate();
  const nav=useNavigate();
  const [profile, setprofile] = useState({
    firstname: "",
    lasrtname: "",
    dateOfBirth: "",
    gender: "",
    street: "",
    location: "",
    city: "",
    state: "",
    pincode: "",
    mobileNo: "",
    emailId: "",
    credentialsbean: {
      userId: "",
      password: "",
      userType: "C",
      loginStatus: "True",
    },
  });

  const handlechange = (e) => {
    setprofile({ ...profile, [e.target.id]: e.target.value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();

    console.log(profile)
    Service.Addprofile(profile);
        console.log(profile)
      alert("Profile is added");

      navigate("/");
    
  };
  return (
    <div>
      <form onSubmit={handleSubmit} className='Container1'>
        <h2>Add User Profile</h2>
        <div className="flex">

        <div className="box">
        <div className='input-box'>
        <label className="details">First Name</label>
        <input id="firstName" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">last Name</label>
        <input id="lastName" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">Date of Birth</label>
        <input id="dateOfBirth" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">Gender</label>
        <input id="gender" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">Street</label>
        <input id="street" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">Location</label>
        <input id="location" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">City</label>
        <input id="city" onChange={handlechange} required />
        </div>
        </div>

        <div className="detail-box">
        <div className='input-box'>
        <label className="details">State</label>
        <input id="state" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">Pincode</label>
        <input id="pincode" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">Mobile No</label>
        <input id="mobileNo" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">Email-ID</label>
        <input id="emailID" type="email" onChange={handlechange} required />
        </div>
        <div className='input-box'>
        <label className="details">UserName</label>
        <input
          id="userId"
          onChange={(e) => {
            setprofile({
              ...profile,
              credentialsbean: {
                ...profile.credentialsbean,
                [e.target.id]: e.target.value,
              },
            });
          }}
          required
        />
        </div>
        <div className='input-box'>
        <label className="details">Password</label>
        <input
          id="password"
          onChange={(e) => {
            setprofile({
              ...profile,
              credentialsbean: {
                ...profile.credentialsbean,
                [e.target.id]: e.target.value,
              },
            });
          }}
          required
        />
        </div>
        </div>
      
        </div>
        
        <button  className='btn btn-primary'type="submit">Submit</button>
        <button className='btn btn-danger'style={{marginLeft:"10px"}} onClick={(e)=>{nav('/')}}type="submit" >Cancel</button>
      </form>
    </div>
  );
}

export default Addprofile;
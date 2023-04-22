import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import './CreateShip.css'
function Login() {
  const[name,setName]=useState("");
  const[pass,setPass]=useState("");
  const nav=useNavigate();

 

  const handleSubmit=(e)=>{
    e.preventDefault(e.target.value);

    if(name=="AD-001" && pass=="AD-001"){
      nav("/ship");
    }
    else if(name=="AD-002" && pass=="AD-002"){
      nav("/viewship")
    }
    else if(name=="AD-003" && pass=="AD-003"){
      nav("/deleteship")
    }
    else if(name=="AD-004" && pass=="AD-004"){
      nav("/viewRoute")
    }
    else if(name=="AD-005" && pass=="AD-005"){
      nav("/addRoute")
    }
    else if(name=="AD-006" && pass=="AD-006"){
      nav("/deleteRoute")
    }
    else if(name=="AD-007" && pass=="AD-007"){
      nav("/viewSchedule")
    }
    else if(name=="AD-008" && pass=="AD-008"){
      nav("/deleteSchedule")
    }
    else if(name=="AD-009" && pass=="AD-009"){
      nav("/addSchedule")
    }
    else if(name=="AD-010" && pass=="AD-010"){
      nav("/updateShip")
    }
    else{
      nav("/")
    }
  }
  return (
    <div>
      <h2>Admin Login</h2>
      <form onSubmit={handleSubmit} className='Container'>
      <div className='input-box'>
      <label className="details"for="name"><b>UserName:</b></label>
      <input  type='text' placeholder='User Name' value={name} onChange={(e)=>setName(e.target.value)}/>
      </div>
      <div className='input-box'>
      <label className="details"for="name"><b>Password:</b></label>
      <input type='text' placeholder='Password' value={pass} onChange={(e)=>setPass(e.target.value)}/>
      <button className='btn btn-primary'>Submit</button>
      <button className='btn btn-danger'style={{marginLeft:"10px"}} onClick={(e)=>{nav('/')}}type="submit" >Cancel</button>
      </div>
      </form>
    </div>
  )
}

export default Login

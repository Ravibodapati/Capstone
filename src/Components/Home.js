import React, { useEffect, useState } from "react";
import { Service } from '../Service/Adminworker'
import { Link, useNavigate } from "react-router-dom";
import './CreateShip.css'


function Home() {

  const nav=useNavigate();

  const [userId, setuserId] = useState();
  const [password, setpassword] = useState();
  const [submit, setsubmit] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    if (submit) {
      Service.getLogin(userId, password).then((res) => {
        alert(res);
        if (res === true) {
          Service.getusrById(userId).then((res) => {
            
              navigate(`/Login`);
              
            
          });
        } else if (res === false) {
          alert("Sign up first");
          setsubmit(false);
          alert("Sign up first");
          navigate(`/profileadd`);
        }
      });
    }
  }, [submit, userId, password, navigate]);

  

  const handleuser = (e) => {
    setuserId(e.target.value);
  };
  const handlepassword = (e) => {
    setpassword(e.target.value);
  };

  const handlesubmit = (e) => {
    e.preventDefault();
    setsubmit(true);
  };
  return (
    <div>
      <h1>Welcome to kakinada Port</h1>
      <h2>User Login</h2>
      <form onSubmit={handlesubmit} className='Container'>
      <div className='input-box'>
        <label  className="details">UserName</label>
        <input type="text" onChange={handleuser} />
        </div>
        <div className='input-box'>
        <label className="details">Password</label>
        <input  type="password" onChange={handlepassword} />
        </div>
        <button  className='btn btn-primary'type="submit">Submit</button>
        <button className='btn btn-danger'style={{marginLeft:"10px"}} onClick={(e)=>{nav('/')}}type="submit" >Cancel</button>
          <Link style={{marginLeft:"10px"}} to={`/profileadd/`}>Register here?</Link>
      </form>
    </div>
  );
}

export default Home;
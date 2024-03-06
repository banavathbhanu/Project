import React, { useState } from "react"
import 'bootstrap/dist/css/bootstrap.min.css'
import {  useNavigate,Link} from "react-router-dom";
import './App.css';
import swal from 'sweetalert2';

import axios from "axios";


export default function (props)
{

  const[email,setEmail]=useState("");
  const[passw,setPassw]=useState("");
  const navigate=useNavigate();
  const showmessage=(message)=>
  {
    swal.fire({
      icon:'error',
      title:'Login failure',
      text:message

    });
  }
  const showmessagesu=(message)=>
  {
    swal.fire({
      icon:'success',
      title:'Login Successful',
      text:message

    });
  }
  async function check(event){
    event.preventDefault();
    try{
      await axios.post("http://localhost:8089/user/login",{
        email:email,
        password:passw,
      }).then((res)=>{
        console.log(res.data.messsage);
        if(res.data.messsage==="Email Does not exist")
        {
          // alert("Email not registered");
          showmessage("Email not registered");
          navigate('/register');
        }
        else if(res.data.messsage==="Login Success")
        {
          localStorage.setItem('userid',res.data.id)
          console.log(res.data.id);
          showmessagesu("Login Successfull");
          navigate("/Uservisible/"+res.data.id);
        }
        else
        {
          showmessage("Password and email does not exist");
          
        }
      },fail=>{
        console.error(fail);
      });
    }
    catch(err)
    {
      showmessage("Could not login")
    }
  }
    return (
        <div className="form-container" >
      <form className="login-form">
        <div className="form-content">
          <h3 className="form-title">Login</h3>
          <div className="form-group mt-3">
            <label>Email address</label>
            <input
              type="email"
              className="form-control mt-1"
              placeholder="Enter email"
              value={email}
              name="email"
              onChange={(event)=>{setEmail(event.target.value);}}
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              className="form-control mt-1"
              placeholder="Enter password"
              value={passw}
              name="passw"
              onChange={(event)=>{setPassw(event.target.value);}}
            />
          </div>
          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-primary" onClick={check}>
            Submit
            </button>
          </div>
          <div className="d-grid gap-2 mt-3">
          <Link to='/register' style={{backgroundColor:"lightblue",color:'ButtonText'}} className="btn btn-primary mb-2">Create an Account</Link>
          </div>
        </div>
      </form>
    </div>
    )
}
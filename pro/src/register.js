import React,{useState} from "react"
import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import axios from "axios";
import { useNavigate } from "react-router-dom";
import swal from 'sweetalert2';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
export default function(props)
{

    const[id,setId]=useState('');
    const[name,setName]=useState("");
    const[email,setEmail]=useState("");
    const[passw,setPassw]=useState("");
    const navigate=useNavigate();
    const showmessage=(message)=>
    {
      swal.fire({
        icon:'error',
        title:'Registration failure',
        text:message
  
      });
    }
    const successful=(message)=>
    {
      swal.fire({
        icon:'success',
        title:'Registration Sucess',
        text:message
  
      });
    }
   async function save(event)
   {
    event.preventDefault();
    try
    {
      await axios.post("http://localhost:8089/user/save",
      {
        username:name,
        email:email,
        password:passw


      }).then((response)=>{
        console.log(response.data)
        if(response.data==="User registered successfully")
        {
          successful("Registration successfull");
          setName("");
          setEmail("");
          setPassw("");
          navigate("/login")
        }
        else if(response.data==="User Already Exists")
        {
          showmessage("User already exists");
        }
        
    }).catch((error)=>{
        console.log(error.response);
        showmessage(error.response.data)
    })
      

    }
    catch(err)
    {
      showmessage("Registration failed");
    }
   }
    return(
      <>
      <Navbar bg="primary" variant="dark">
        <Container>
          <Navbar.Brand href="/">HOME FOOD ORDERING</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="./login">Login</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
        <div className="form-container">
      <form className="login-form">
        <div className="form-content">
          <h3 className="form-title"> Register</h3>
          <div className="form-group mt-3">
            <label>User Name</label>
            <input
              type="text"
              className="form-control mt-1"

              value={name}
              onChange={(event)=>{setName(event.target.value);}}
              
            />
          </div>
          <div className="form-group mt-3">
            <label>Email address</label>
            <input
              type="email"
              className="form-control mt-1"
              placeholder="Email Address"

              value={email}
              onChange={(event)=>{setEmail(event.target.value);}}
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              className="form-control mt-1"
              placeholder="Password"

              value={passw}
              onChange={(event)=>{setPassw(event.target.value);}}
            />
          </div>
          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-primary"  onClick={save}>
              Submit
            </button>
          </div>
        </div>
      </form>
    </div>
    </>
  )
}
import React from "react";
import { useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import './Home.css'
import {Link } from "react-router-dom";

export default function() {
  const navigate=useNavigate("")
  const explore=()=>
  {
    navigate('/Explore')
  }
  return (
    <>
      
      <Navbar  className="navcss">
        <Container >
          <Navbar.Brand href="#home" style={{color:"whitesmoke"}}>HOME FOOD ORDERING</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="./register" style={{color:"whitesmoke"}}>Register</Nav.Link>
            <Nav.Link href="./login" style={{color:"whitesmoke"}}>Login</Nav.Link>
            <Nav.Link href="./Adminlogin" style={{color:"whitesmoke"}}>AdminLogin</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      
      <div className="bg">
      <button className = "bu"  type="submit" onClick={explore}>Explore the Food Items</button>
        <div class="bg-text">
          <p>
            StepInStyle
          </p>
        </div>
        </div>

     
    </>
  );
}


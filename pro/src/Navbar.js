import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

export default function() {
  return (
    <>
      
      <Navbar bg="primary" variant="dark">
        <Container>
          <Navbar.Brand href="/">HOME FOOD ORDERING</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="./register">Register</Nav.Link>
            <Nav.Link href="./login">Login</Nav.Link>
            <Nav.Link href="./Adminlogin">AdminLogin</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

     
    </>
  );
}


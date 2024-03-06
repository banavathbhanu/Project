import React,{useEffect, useState}from "react";
import {useParams,Link, useNavigate} from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Dropdown from 'react-bootstrap/Dropdown';
import { FormControl, FormGroup, InputGroup } from "react-bootstrap";
import Card from 'react-bootstrap/Card';
import Service from "./Service";
import Row from 'react-bootstrap/Row'; 
import Col from 'react-bootstrap/Col';
import './Uservisible.css';

const Uservisible=()=> {
  const[allProducts,setAllProducts]=useState([]);
  const[category,setCategory]=useState('all')
  const[search,setSearch]=useState('')
  const[count,setCount]=useState(0)
  const {uid}=useParams();
  const navigate=useNavigate();
 
  useEffect(()=>{
    Service.getProduct().then((response)=>{
        console.log(response.data)
        setAllProducts(response.data)

    }).catch((error)=>{
        console.log(error);
    })
  },[])
  // const cartcount=async ()=>
  // {
  //   const res=await axios.get(`http://localhost:8790/addto/gettotal/${uid}`)
  //   setCount(res.data)
  //   navigate('/Cart')
  // }
const logout=()=>{
  localStorage.clear();
  navigate("/")
}
const categoryhandler=(c)=>
{
  setCategory(c);

}
const filteritem=allProducts.filter(products=>{

  const categoryMatch=category==='all'||products.itemname===category;
  const searchMatch = products.itemname.toLowerCase().includes(search.toLowerCase());
  return categoryMatch&&searchMatch;

 })
 const ordernow=(id)=>
 {
   
   navigate('/Ordering/'+id);
 }
 const Addtocart=(id)=>
 {
    navigate('/Addtocart/'+id)
 }

 const Previous=()=>
 {
  navigate('/Previous')
 }
return (
  <div>
    <div className="container-fluid container1">
    <table><tr>
      <td className="heading">Home Food Ordering System</td>
      <td>
    <form>

      <InputGroup className="my-3">

        <FormControl onChange={(e)=>setSearch(e.target.value)} placeholder="search"></FormControl>

      </InputGroup>

    </form>
    </td><td>
     <Dropdown>
      <Dropdown.Toggle className="category" id="dropdown-basic">
        Category
      </Dropdown.Toggle>

      <Dropdown.Menu>
      <Dropdown.Item ><div onClick = {() => categoryhandler('all')} >All </div></Dropdown.Item>
        <Dropdown.Item ><div onClick = {() => categoryhandler('Boots')} >Boots </div></Dropdown.Item>
        <Dropdown.Item ><div  onClick = {() => categoryhandler('Crocs')} >Crocs </div></Dropdown.Item>
        <Dropdown.Item ><div  onClick = {() => categoryhandler('Sandals')} >Sandals </div></Dropdown.Item>
        <Dropdown.Item ><div  onClick = {() => categoryhandler('Sneakers')} >Sneakers </div></Dropdown.Item>
      </Dropdown.Menu>
    </Dropdown><br/></td>
    {/* <td><Link to="/Previous" className="btn btn-success"> Orders </Link></td> */}
    <td><button className = "btn btn-success" onClick = {() => Previous()} >Orders </button></td>
    <td><button className = "btn btn-success" onClick = {(e) => logout(e)} >Logout </button></td>
    <td><Link to="/Cart"  className="btn btn-success"> Cart </Link></td>
    
    </tr>
    </table>
    </div><br/>
    <div style={{paddingLeft:80}}>
    <Row xs={1} md={3} classname="g-4">
  {
    filteritem.map(
        (ap)=>(
          <Col>
  <Card style={{ width: '18rem' }}>
        
            <Card.Img variant="top" src={`data:image/png/jpeg/jpg;base64,${ap.image}`} alt="Event" height={200} width={180} />
    <Card.Body>
      <Card.Title>{ap.itemname}</Card.Title>
      <Card.Text>Homemakername:{ap.homemakername}
      </Card.Text>
      <Card.Text>Price:{ap.price}</Card.Text>
      <Card.Text>Availability:{ap.availability}</Card.Text>
      {/* <Link to={`/Ordering/${ap.id}`}  className="btn btn-primary mb-2">Order Now</Link> */}
      <button className = "orn"  type="submit" disabled={ap.availability===0} onClick={(e)=>ordernow(ap.id)}>Order Now </button>
      {/* <Link to={`/Addtocart/${ap.id}`} className="btn btn-primary mb-2">Addtocart</Link> */}
      <button className = "orn"  type="submit" disabled={ap.availability===0} onClick={(e)=>Addtocart(ap.id)}>Add to Cart </button>
    </Card.Body>
  </Card><br/>
  </Col>
        ))
        }
        </Row>
        </div>
  </div>
);
      }

export default Uservisible;
import React,{useEffect, useState}from "react";
import {useParams,Link, useNavigate} from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Dropdown from 'react-bootstrap/Dropdown';
import { FormControl, FormGroup, InputGroup } from "react-bootstrap";
import Card from 'react-bootstrap/Card';
import Service from "./Service";
import Row from 'react-bootstrap/Row'; 
import Col from 'react-bootstrap/Col';
import './Explore.css';

const Explore=()=> {
  const[allProducts,setAllProducts]=useState([]);
  const[category,setCategory]=useState('all')
  const[search,setSearch]=useState('')
  const navigate=useNavigate();
 
  useEffect(()=>{
    Service.getProduct().then((response)=>{
        console.log(response.data)
        setAllProducts(response.data)

    }).catch((error)=>{
        console.log(error);
    })
  },[])
const categoryhandler=(c)=>
{
  setCategory(c);

}
const loginnav=()=>
{
  navigate('/login')
}
const filteritem=allProducts.filter(products=>{

  const categoryMatch=category==='all'||products.itemname===category;

  const searchMatch = products.itemname.toLowerCase().includes(search.toLowerCase());

  return categoryMatch&&searchMatch;

 })
 
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
      <Dropdown.Toggle className="categorycss" id="dropdown-basic">
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
    
    <td><button className = "tdlo"  type="submit" onClick={loginnav}>Login </button></td>
    </tr>
    </table>
    </div><br/>
    <div style={{paddingLeft:60}}>
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
      <button className = "orn"  type="submit" onClick={loginnav}>Order Now </button>
      <button className = "orn"  type="submit" onClick={loginnav}>Add to cart </button>
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

export default Explore;

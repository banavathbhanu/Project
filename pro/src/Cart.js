import axios from "axios";
import React,{useEffect, useState} from "react";
import { useParams,Link ,useNavigate} from "react-router-dom";
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import './Cart.css';
const Cart=()=>
{
    const[cart,setCart]=useState([])
    const[tp,setTp]=useState("")
    const[proid,setProid]=useState("")
    const[availability,setAvailability]=useState("")
    const uid=localStorage.getItem("userid")
    const navigate=useNavigate()
    useEffect(()=>
    {
        getItems();
        
    },[])
    const getItems=async ()=>{
        const response=await axios.get(`http://localhost:8790/addto/get/${uid}`)
        console.log(response.data)
        setCart(response.data);
        setProid(cart.pid);
        console.log(proid)
        const res=await axios.get(`http://localhost:8790/addto/gettotal/${uid}`)
        //console.log(res.data)
        setTp(res.data)
        console.log(cart.length)
        
    }
    const deleteProduct = async(productId) => {
        console.log("enter")
        await axios.delete(`http://localhost:8790/addto/${productId}`)
        getItems();
        // window.location.reload();
        
         
     }
    // const getavailability= async(cart.pid)=>{
    //     const result=await axios.get(`http://localhost:8083/product/availability/${cart.pid}`)
    //     console.log(result.data)
    //  }

    const getavailability = async(proid) => {
        console.log("enter")
        const r=await axios.get(`http://localhost:8083/product/availability/${proid}`)
        console.log(r.data)
        setAvailability(r.data)

        
         
     }
     const bookNow=()=>
     {
       navigate('/BookNow')
     }
    return(
        <>
        
      <Navbar style={{backgroundColor:"darkslategray"}} variant="dark">
        <Container>
          <Navbar.Brand href={`/Uservisible/${uid}`}>HOME FOOD ORDERING</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="./">Logout</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      {
        (cart.length===0)?<div>
        <div className="OrderBox">
            <img src={require("./face.png")} className="imamodi" alt="sad"/>
            <div className="Ordernot">There are no items in cart</div>
            <div className="Notpresent">How about you get started</div></div>

            <Link to ={`/Uservisible/${uid}`}><button className="Orderbutton">Explore</button></Link>

</div>:
        <div className="container">
            <h2 className="text-center">Cart Items</h2>
            <table className="table table-bordered table-stripped">
                <thead>
                    <tr>
                    <th>Product_Image</th>
                    <th>Quantity</th>
                   
                    <th>Price</th>
                    <th>Original Price</th>
                    <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {
                    cart.map(
                        (cart,num) =>(
                        <tr key={cart.id}>
                            <td><img src={`data:image/png/jpeg/jpg;base64,${cart.image}`} alt="Event" height={50} width={50}/></td>
                            <td>{cart.quantity}</td>
                            
                            <td>{cart.price}</td>
                            <td>{cart.orprice}</td>

                            <td>
                                    <button className = "btn btn-danger" onClick = {() => deleteProduct(cart.pid)}
                                    style = {{marginLeft:"10px"}}> Delete</button>
                                </td>
                        </tr>

                    ))
                    }
                </tbody>
            </table>
            <h4 >Total price of the cart is :{tp}</h4>
            {/* <Link to="/BookNow" className="as" disabled={availability===0}> BookNow </Link> */}
            <button className = "as"  type="submit"  onClick={bookNow}>BookNow </button>
        </div>
        
}
        </>

    )
}
export default Cart;

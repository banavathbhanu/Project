import axios from "axios";
import React,{useEffect, useState} from "react";
import Table from 'react-bootstrap/Table';
import './prev.css';
import { useParams,Link ,useNavigate} from "react-router-dom";
const Previous=()=>
{
    const[orders,setOrders]=useState([])
    const[cartorders,setCartorders]=useState([])
    const navigate=useNavigate()
    const uid=localStorage.getItem("userid")
    useEffect(()=>
    {
        getItems();
    },[]);
    const getItems=async ()=>{
        const response=await axios.get(`http://localhost:8074/cart/userorders/${uid}`)
        //console.log(response.data)
        setCartorders(response.data);
        const res=await axios.get(`http://localhost:8086/order/userorders/${uid}`)
        //console.log(res.data)
        setOrders(res.data)
        
        //setOrders(orders.concat(cartorders));
        
    }
    //getItems();
    // console.log(orders)
    // console.log(cartorders)
    const back=()=>
      {
        navigate(`/UserVisible/${uid}`)
      }
    return(
        <>
        {
            (orders.length===0&&cartorders.length===0)?
            <div>
                <div className="OrderBox">
                    <img src={require("./face.png")} className="imamodi" alt="sad"/>
                    <div className="Ordernot">You have no Orders</div>
                    <div className="Notpresent">How about you get started</div></div>

                    <Link to ={`/Uservisible/${uid}`}><button className="Orderbutton">Explore</button></Link>

        </div>:
        <div className="container">
            <h2 className="text-center">Orders</h2>
            <button className = "btn btn-success" onClick = {(e) => back(e)} >Back </button><br/><br/>
            <Table striped bordered hover size="sm">
                <thead>
                   <tr> 
                    <th>Product_Image</th>
                    <th>Quantity</th>
                    
                    <th>Price</th>
                    <th>Username</th>
                    <th>Address</th>
                    </tr>
                </thead>
                <tbody>
                    {
                    orders?.map(
                        (orders,num) =>(
                        <tr key={orders.id}>
                            <td><img src={`data:image/png/jpeg/jpg;base64,${orders.image}`} alt="Event" height={50} width={50}/></td>
                            <td>{orders.quantity}</td>
                            
                            <td>{orders.price}</td>
                            <td>{orders.username}</td>
                            <td>{orders.address}</td>

                        </tr>

                    ))
                    }
                    {
                    cartorders?.map(
                        (orders,num) =>(
                        <tr key={orders.id}>
                            <td><img src={`data:image/png/jpeg/jpg;base64,${orders.image}`} alt="Event" height={50} width={50}/></td>
                            <td>{orders.quantity}</td>
                           
                            <td>{orders.price}</td>
                            <td>{orders.username}</td>
                            <td>{orders.address}</td>

                        </tr>

                    ))
                    }
                </tbody>
            </Table>
        </div>
}
        </>

    )
}
export default Previous;
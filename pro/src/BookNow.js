import React, { useEffect } from "react";
import  { useState } from "react";
import { useParams,Link, Navigate ,useNavigate} from "react-router-dom";
import axios from "axios";
const BookNow=()=>
{
    const[username,setUsername]=useState("")
    const[address,setAddress]=useState("")
    const[contact,setContact]=useState("")
    const[totalprice,setTotalprice]=useState("")
    const navigate=useNavigate();
    const uid=localStorage.getItem("userid")
    async function Order(e)
   
    {
        e.preventDefault();
        
      try{
        const response=await axios.post('http://localhost:8074/cart/send/'+uid,
        {
            uid:uid,
            username:username,
            address:address,
            contact:contact,

        },
        {
            headers:
            {
                "Content-Type":'multipart/form-data'
            }
        });
        console.log(response.data)
        setTotalprice(response.data);
        const res=await axios.delete(`http://localhost:8790/addto/del/${uid}`)
        console.log(res.data)
        navigate(`/Orderplaced/${response.data}`)
    }
    catch(err)
        {
            console.log(err.response.data)
            alert("Order failed to placed")
        }
    }
    return(
        <div>
        <br /><br />
        <div className = "container">
             <div className = "row">
                 <div className = "card col-md-6 offset-md-3 offset-md-3">
                   <h2>Order Product</h2>
                     <div className = "card-body">
                         <form encType='multipart/form-data' onSubmit={Order}>
                             <div className = "form-group mb-2">
                                 <label className = "form-label"> Name</label>
                                 <input
                                     type = "text"
                                     placeholder = "Enter your name"
                                     name = "name"
                                     className = "form-control"
                                     value = {username}
                                     onChange = {(e) => setUsername(e.target.value)}
                                 >
                                 </input>
                             </div>
 
                             <div className = "form-group mb-2">
                                 <label className = "form-label"> Address :</label>
                                 <input
                                     type = "text"
                                     placeholder = "Enter Address"
                                     name = "address"
                                     className = "form-control"
                                     value = {address}
                                     onChange = {(e) => setAddress(e.target.value)}
                                 >
                                 </input>
                             </div>
                             <div className = "form-group mb-2">
                                 <label className = "form-label"> Contact</label>
                                 <input
                                     type = "text"
                                     placeholder = "Enter Contact"
                                     name = "contact"
                                     className = "form-control"
                                     value = {contact}
                                     onChange = {(e) => setContact(e.target.value)}
                                 >
                                 </input>
                             </div>
 
                             <button className = "btn btn-success"  type="submit" >Order </button>
                             <Link to="/Cart" className="btn btn-danger"> Cancel </Link>
                         </form>
 
                     </div>
                 </div>
             </div>
 
        </div>
 
     </div>

    )
}
export default BookNow;
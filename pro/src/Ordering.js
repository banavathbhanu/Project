import React, { useEffect } from "react";
import  { useState } from "react";
import { useParams,Link, Navigate ,useNavigate} from "react-router-dom";
import axios from "axios";
import swal from 'sweetalert2';
const Ordering=()=>
{
    const[username,setUsername]=useState("")
    const[address,setAddress]=useState("")
    const[contact,setContact]=useState("")
    const[quantity,setQuantity]=useState("")
    //const[size,setSize]=useState("")
    const[price,setPrice]=useState("")
    const navigate=useNavigate();
    // const[price,setPrice]=useState("")
    // const {data} =useLocation().data;

     
    const {id}=useParams();
    const uid=localStorage.getItem("userid")
    useEffect(()=>{
        console.log(id);
        console.log(uid);
    },[]);

    const showmessage=(message)=>
    {
      swal.fire({
        icon:'error',
        title:'Order cannot be placed ',
        text:message
  
      });
    }
    const showmessagea=(message)=>
    {
      swal.fire({
        icon:'error',
        title:'Invalid details ',
        text:message
  
      });
    }
    async function orderproduct(e)
    {
        e.preventDefault();
        if(contact.length!==10 && quantity>0)
        {
            showmessagea("Plese enter valid details")
        }
        else{
        try
        {
            const res=await axios.post("http://localhost:8086/order/pos/"+id,
            {
                uid:uid,
                username:username,
                address:address,
                contact:contact,
                quantity:quantity,
               // size:size,

            },
            {
                headers:
                {
                    "Content-Type":'multipart/form-data'
                }
            });
            setUsername("")
            setAddress("")
            setContact("")
            setQuantity("")
            //setSize("")
            if(res.data===-1){
                const resu=await axios.get("http://localhost:8083/product/Price/"+id)
                console.log(resu.data)
                console.log(quantity)
                navigate("/Orderplaced/"+resu.data*quantity)
            }
            else{
                console.log(res.data)
                
                showmessage("Number of products available are "+res.data)
            }
            //alert("Successfull"+res.data);

        }
        catch(err)
        {
            console.log(err.response.data)
            alert("Order failed to placed")
        }
    }
    }
return (
    <div>
       <br /><br />
       <div className = "container">

            <div className = "row">
                <div className = "card col-md-6 offset-md-3 offset-md-3">
                  <h2>Order Product</h2>
                    <div className = "card-body">
                        <form encType='multipart/form-data'>
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
                            <div className = "form-group mb-2">
                                <label className = "form-label"> Quantity</label>
                                <input
                                    type = "number"
                                    placeholder = "Enter Quantity"
                                    name = "quantity"
                                    className = "form-control"
                                    value = {quantity}
                                    onChange = {(e) => setQuantity(e.target.value)}
                                >
                                </input>
                            </div>
                            

                            <button className = "btn btn-success" onClick = {(e) => orderproduct(e)} >Order </button>
                            <Link to={`/Uservisible/${uid}`} className="btn btn-danger"> Cancel </Link>
                        </form>

                    </div>
                </div>
            </div>

       </div>

    </div>
)
}
export default Ordering;

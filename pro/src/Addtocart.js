import React,{useEffect, useState} from "react";
import { useParams,Link ,useNavigate} from "react-router-dom";
import axios from "axios";
import swal from 'sweetalert2'
const Addtocart=()=>
{
    const[quantity,setQuantity]=useState("")
    //const[size,setSize]=useState("")
    const[price,setPrice]=useState("")
    const {pid}=useParams();
    const navigate=useNavigate("")
    
    const uid=localStorage.getItem("userid")
    const successful=(message)=>
    {
      swal.fire({
        icon:'success',
        title:'Success',
        text:message
  
      });
    }
    const showmessage=(message)=>
    {
      swal.fire({
        icon:'error',
        title:'Cannot be added to cart ',
        text:message
  
      });
    }
    async function addtocart(e)
    {
        e.preventDefault();
        try
        {
            const res=await axios.post("http://localhost:8790/addto/store/"+pid,
            {
                uid:uid,
                quantity:quantity,
               // size:size,

            },
            {
                headers:
                {
                    "Content-Type":'multipart/form-data'
                }
            });
            setQuantity("")
            //setSize("")
            setPrice("")
            if(res.data===-1){
            successful("Product added to cart")
            navigate(`/Uservisible/${uid}`);}
            else{
                console.log(res.data)
                
                showmessage("Number of products available are "+res.data)
            }

        }
        catch(err)
        {
            alert("Cannot add to cart")
        }
    }
    return(
        <div>
       <br /><br />
       <div className = "container">
            <div className = "row">
                <div className = "card col-md-6 offset-md-3 offset-md-3">
                  <h2>Add Product to Cart</h2>
                    <div className = "card-body">
                        <form encType='multipart/form-data'>
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
                            

                            <button className = "btn btn-success" onClick = {(e) => addtocart(e)} >Add </button>
                            <Link to={`/Uservisible/${uid}`}  className="btn btn-danger"> Cancel </Link>
                        </form>

                    </div>
                </div>
            </div>

       </div>

    </div>
    )
}
export default Addtocart;
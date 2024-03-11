import React, {useState, useEffect} from 'react'
import axios from "axios";
import {Link, Navigate, useNavigate, useParams } from 'react-router-dom';
import Service from './Service'

const UpdateProduct = () => {

    const[image,setImage]=useState('');
    const [itemname, setitemname ]= useState('')
    const [homemakername, sethomemakername] = useState('')
    const [price, setPrice] = useState('')
    const [availability,setAvailability]= useState('')
    const {id} = useParams();
    const navigate=useNavigate();
useEffect(()=>{
    Service.getProductById(id).then((response)=>{
        console.log(response)
        setitemname(response.data.itemname)
        sethomemakername(response.data.homemakername)
        setPrice(response.data.price)
        setAvailability(response.data.availability)
    }).catch((err)=>{
        console.log(err)
    })
},[])
async function Updation(e){
    e.preventDefault();
    
    Service.updateProduct(id,image,itemname,homemakername,price,availability).then((response)=>{
        console.log(response);
        navigate('/ProductsList')
    }).catch((err)=>{
        console.log(err)
    })
    const res=await axios.get("http://localhost:8790/addto/item/" + id);
    if(res.data===1)
    {
        const p=await axios.get("http://localhost:8790/addto/price/" +id);
        if(p.data!=price)
        {
          console.log(p.data,"hii",price)
           const f=await axios.put("http://localhost:8790/addto/" + id+"/"+price);
           console.log(f.data);
        }
    }
}

    return (
        <div>
           <br /><br />
           <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                       <h2>Update Product</h2>
                        <div className = "card-body">
                            <form encType='multipart/form-data'>
                            <div className = "form-group mb-2">
                                    <label className = "form-label"> Product image :</label>
                                    <input
                                        type = "file"
                                        placeholder = "Upload image"
                                        name = "image"
                                        className = "form-control"
                                        files = {image}
                                        onChange = {(e) => setImage(e.target.files[0])}
                                    >
                                    </input>
                                </div>
                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Itemname</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter Item name"
                                        name = "itemname"
                                        className = "form-control"
                                        value = {itemname}
                                        onChange = {(e) => setitemname(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Homemakername :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter Homemaker name"
                                        name = "homemakername"
                                        className = "form-control"
                                        value = {homemakername}
                                        onChange = {(e) => sethomemakername(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Price</label>
                                    <input
                                        type = "number"
                                        placeholder = "Enter the Price"
                                        name = "price"
                                        className = "form-control"
                                        value = {price}
                                        onChange = {(e) => setPrice(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className = "form-group mb-2">
                                    <label className = "form-label">Availability</label>
                                    <input
                                        type = "number"
                                        placeholder = "Enter the Availability"
                                        name = "availability"
                                        className = "form-control"
                                        value = {availability}
                                        onChange = {(e) => setAvailability(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <button className = "btn btn-success" onClick = {(e) => Updation(e)} >Submit </button>
                                <Link to="/ProductsList" className="btn btn-danger"> Cancel </Link>
                            </form>

                        </div>
                    </div>
                </div>

           </div>

        </div>
    )
}

export default UpdateProduct

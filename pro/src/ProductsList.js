import React,{useEffect, useState} from "react";
import { Link ,useNavigate} from 'react-router-dom'
import axios from 'axios'
import Service from "./Service";
import './Productlist.css';
const ProductsList=()=>
{
    const[products,setProducts]=useState([])
    const[totalPages,setTotalPages]=useState(0);
    const[currentPage,setCurrentPage]=useState(0);
    const navigate=useNavigate()
    useEffect(()=>
    {
        getProduct();
    },[currentPage])
     const getProduct= async()=>{
        // Service.getProduct().then((response)=>{
        //     setProducts(response.data)
        //     console.log(response)
        //     console.log(response.data);
        //     setTotalPages(response.headers.get('total pages'));
        // }).catch(error=>{
        //     console.log(error);
        // })
        try{
            const response=await axios.get("http://localhost:8083/product/pagination",{
                params:{page:currentPage}
            })
            setProducts(response.data.content);
            setTotalPages(response.data.totalPages)
        }catch(error)
        {
            console.log(error)
        }
    }
    const deleteProduct =  (productId) => {
        Service.deleteProduct(productId).then(async function (response) {
            getProduct();
            const resu = await axios.get("http://localhost:8790/addto/getitem/" + productId);
            if(resu.data===1)
            {
                const res=await axios.delete("http://localhost:8790/addto/"+productId);
            }

        }).catch(error =>{
            console.log(error);
        })
         
     }
     const logout=()=>{
        localStorage.clear();
        navigate("/")
      }
    return(
        <div className="container">
            <h2 className="text-center">Products</h2>
            <Link to = "/addProduct" className = "btn btn-primary mb-2" > Add Product </Link>
            <button className = "btn btn-success" id="log" onClick = {(e) => logout(e)} >Logout </button>
            <table className="table table-bordered table-stripped">
                <thead >
                    <tr>
                    <th>Product_Id</th>
                    <th>Product_Image</th>
                    <th>ItemName</th>
                    <th>HomemakerName</th>
                    <th>Price</th>
                    <th>Availability</th>
                    <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                    products.map(
                        (product,num) =>(
                        <tr key={product.id}>
                            <td>{product.id}</td>
                            <td><img src={`data:image/png/jpeg/jpg;base64,${product.image}`} alt="Event" height={50} width={50}/></td>
                            <td>{product.itemname}</td>
                            <td>{product.homemakername}</td>
                            <td>{product.price}</td>
                            <td>{product.availability}</td>

                            <td>
                                    <Link className="btn btn-info" to={`/updateproduct/`+product.id} >Update</Link>
                                    <button className = "btn btn-danger" onClick = {() => deleteProduct(product.id)}
                                    style = {{marginLeft:"10px"}}> Delete</button>
                                </td>
                        </tr>

                    ))
                    }
                    
                </tbody>
            </table>
            <div id="page">
            <button className="pagination-button" disabled={currentPage===0} onClick={()=>setCurrentPage(prevPage=>prevPage-1)}>Previos page</button>
            <button className="pagination-button" disabled={currentPage===totalPages-1} onClick={()=>setCurrentPage(prevPage=>prevPage+1)}>Next page</button>
            </div>
        </div>

    )
}
export default ProductsList

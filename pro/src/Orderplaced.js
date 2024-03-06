import React from 'react';
import Card from 'react-bootstrap/Card';
import { useParams,useNavigate} from "react-router-dom";
import './orderplaced.css'
const Orderplaced=()=>{
    const {tp}=useParams();
    const uid=localStorage.getItem("userid")
    const navigate=useNavigate();
    const logout=()=>{
        localStorage.clear();
        navigate("/")
      }
      const back=()=>
      {
        navigate(`/UserVisible/${uid}`)
      }
    return(

        <div className='backg'>
        <table>
        <tr>
        <td><button className = "btcss" onClick = {(e) => back(e)} >Back </button></td>
        <td><button className = "bcss" onClick = {(e) => logout(e)} >Logout </button></td>
        </tr>
        </table>
        <div className='cardcss'>
        <div className='container'>
            <Card className='cardsh'>
            <div className="myImage" />
      <Card.Body>
        <Card.Title>Order Placed Sucessfully</Card.Title>
        <Card.Text>
           Total Price: {tp}
        </Card.Text>
      </Card.Body>
    </Card>

        </div>
        </div>
        </div>
    )
}
export default Orderplaced;
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import swal from 'sweetalert2';
const users = [
  {
    username: 'Bhanu',
    password: 'admin'
  },
  {
    username:'admin2',
    password:'012345678'
  }
];
export default function AdminLogin(props) {
    const[username,setUsername]=useState("");
    const[passw,setPassw]=useState("");
    const navigate=useNavigate();
    const showmessage=(message)=>
  {
    swal.fire({
      icon:'error',
      title:'Login failure',
      text:message

    });
  }
  const showmessagesu=(message)=>
  {
    swal.fire({
      icon:'success',
      title:'Login Successful',
      text:message

    });
  }
  

  const checkUser = (event) => {
    event.preventDefault();
    try{
    const usercheck = users.find(user => (user.username === username && user.password === passw));
    if(usercheck) {
      console.log("Login successful");
      showmessagesu("Login sucessful");
      localStorage.setItem('username',username)
      navigate('/ProductsList')
    }else {
      console.log("Wrong password or username");
      showmessage("Wrong password or username")
      setUsername("")
      setPassw("")
    }
    // console.log(uname);
    console.log(usercheck);
  }
  catch(err)
  {
    alert("Could not login");
  }


}
  return (
    <div className="form-container" >
      <form className="login-form">
        <div className="form-content">
          <h3 className="form-title">AdminLogin</h3>
          <div className="form-group mt-3">
            <label>Username</label>
            <input
              type="text"
              className="form-control mt-1"
              placeholder="Enter username"
              name="username"
              value={username}
              onChange={(event)=>{setUsername(event.target.value);}}
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              className="form-control mt-1"
              placeholder="Enter password"
              value={passw}
              name="password"
              onChange={(event)=>{setPassw(event.target.value);}}
            />
          </div>
          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-primary" onClick={checkUser}>
            Submit
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}
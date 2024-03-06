import "bootstrap/dist/css/bootstrap.min.css"
import "./App.css"
import { BrowserRouter, Routes, Route } from "react-router-dom"
import Login from "./login"
import Home from "./Home"
import Register from "./register"
import Product from "./Product";
import ProductsList from "./ProductsList";
import AddProduct from "./AddProduct"
import UpdateProduct from "./Updateproduct";
import Uservisible from "./Uservisible"
import Ordering from "./Ordering";
import Orderplaced from "./Orderplaced";
import AdminLogin from "./Adminlogin";
import Addtocart from "./Addtocart";
import Cart from "./Cart";
import NoItems from "./NoItems";
import Navbar from "./Navbar";
import BookNow from './BookNow';
import Previous from './Previous';
import Explore from './Explore';

function App() {
  return (
    <>
     {/* <Navbar/>  */}
    <BrowserRouter>
      <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register/>}/>
      <Route path="/ProductsList" element={<ProductsList/>}/>
      <Route path="/addProduct" element={<AddProduct/>}/>
      <Route path="/UserVisible/:uid" element={<Uservisible/>}/>
      <Route path="/updateProduct/:id" element={<UpdateProduct/>}/>
       <Route path="/Ordering/:id" element={<Ordering/>}/>
       <Route path="/Addtocart/:pid" element={<Addtocart/>}/> 
       <Route path="/Orderplaced/:tp" element={<Orderplaced/>}/>
       <Route path="/Adminlogin" element={<AdminLogin/>}/>
       <Route path="/Cart" element={<Cart/>}/>
       <Route path="/BookNow" element={<BookNow/>}/>
       <Route path="/Previous" element={<Previous/>}/>
       <Route path="/Explore" element={<Explore/>}/>
       {/* <Route path="/NoItems" element={<NoItems/>}/> */}
      </Routes>
    </BrowserRouter>
    </>
  )
}


export default App
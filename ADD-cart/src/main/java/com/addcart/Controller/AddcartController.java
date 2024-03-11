package com.addcart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.addcart.Repository.AddtoRepository;
import com.addcart.Service.AddtoService;
import com.addcart.entity.Addcart;
import com.addcart.entity.Item;

@RestController
@RequestMapping("/addto")
@CrossOrigin(origins="http://localhost:3000")
public class AddcartController {
	
	@Autowired
	AddtoService service;
	
	@Autowired
	AddtoRepository repo;
	
	@PostMapping("/store/{pid}")
	public long addto(@PathVariable("pid") int pid,@RequestParam("uid") int uid,@RequestParam("quantity") int quantity) {
		System.out.println("enter");
	    long x=service.updateandaddtocart(pid,uid,quantity);
	    System.out.println("fun....");
	    return x;
	

}
	@GetMapping("/get")
	public List<Addcart> getProdut(){
		return repo.findAll();
	

}
	@GetMapping("/{id}")
	public List<Addcart> getCartById(@PathVariable int id){
		List<Addcart> ad=repo.getitemsbyuid(id);
		System.out.println(ad);
		return ad;
		
	}
	@GetMapping("/total/{id}")
	public long getCartByIdtotal(@PathVariable int id){
		long ad=service.gettotal(id);
		System.out.println(ad);
		return ad;
		
	}
	@PutMapping("/priceincart/{id}/{price}")
	public String updatepriceincart(@PathVariable int id,@PathVariable int price)
	{
		return service.updatecartprice(id,price);
	}
	@GetMapping("/price/{id}")
	public int getCartByIdcount(@PathVariable int id){
		int ad=service.getprice(id);
		System.out.println(ad);
		return ad;
		
	}
	@GetMapping("/item/{pid}")
	public int getproduct(@PathVariable int pid)
	{
	   int x=service.getproduct(pid);	
	   return x;
	}
	@DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){

         repo.deletebypid(id);
         return "deleted";

    }
	@DeleteMapping("/{uid}")
	public String userorderafterdelete(@PathVariable int uid)
	{
		repo.deleteafterorder(uid);
		return "There are no products in the cart";
	}
	
	
	
}	

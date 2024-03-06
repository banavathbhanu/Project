package com.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cartservice.Service.CartService;
import com.cartservice.entity.Cart;
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins="http://localhost:3000")
public class CartController {
	
	@Autowired
	CartService service;
	
	
	@PostMapping("/send/{uid}")
	public Long cart(@PathVariable("uid") int uid,@RequestParam("username") String username,@RequestParam("address") String address,@RequestParam("contact") String contact)
	{
		System.out.println("enter");
	    long x=service.total(uid,username,address,contact);
	    return x;
	}
	@GetMapping("/userorders/{uid}")
	public List<Cart> listoforder(@PathVariable("uid") int id)
	{
		List<Cart> uo=service.findById(id);
		System.out.println(uo);
		return uo;
		
	}
}
	



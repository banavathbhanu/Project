package com.orderservice.Controller;

import java.util.List;

//import java.util.List;

//import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

//import java.util.List;

//import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.orderservice.OrderService.OrderService;
import com.orderservice.entity.Item;
import com.orderservice.entity.Order;



@RestController
@RequestMapping("/order")
@CrossOrigin(origins="http://localhost:3000")
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
		
	@PostMapping(value="/pos/{id}",consumes="multipart/form-data")
	public long order(@PathVariable("id") int pid,@RequestParam("uid") int uid,@RequestParam("quantity") int quantity,@RequestParam("username") String username,@RequestParam("address") String address,@RequestParam("contact") String contact) {
		System.out.println("hiiiii");
	    long x=orderservice.fun(pid,uid,quantity,username,address,contact);
	    return x;

	}
	
	@GetMapping("/userorders/{id}")
	public List<Order> listoforder(@PathVariable("id") int id)
	{
		List<Order> uo=orderservice.findById(id);
		System.out.println(uo);
		return uo;
		
	}


}

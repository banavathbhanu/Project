package com.orderservice.OrderService;

//import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import com.orderservice.entity.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.orderservice.entity.Item;
import com.orderservice.entity.Order;
import com.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OrderRepository repo;

	public long fun(int pid,int uid,int quantity,String username,String address,String contact) {
		// TODO Auto-generated method stub
		System.out.println("hiii");
		
	    String u="http://ADMIN-PRODUCTS/product/update/"+pid+"/"+quantity;
	    int s=restTemplate.exchange(u, HttpMethod.PUT,null,int.class).getBody();
	    if(s!=1)
	    {
	    	return s;
	    }
	    	String url="http://ADMIN-PRODUCTS/product/get/"+pid;
			Item item=restTemplate.getForObject(url,Item.class);
			Order o=new Order();
			o.setPid(pid);
			o.setUid(uid);
			o.setUsername(username);
			o.setAddress(address);
			o.setContact(contact);
		    long price=item.getPrice();
		    o.setQuantity(quantity);
		    o.setImage(item.getImage());
		    o.setPrice(quantity*price);
		   // o.setSize(size);
//		    int updateavailability=item.getAvailability()-quantity;
//		    item.setAvailability(updateavailability);
		    System.out.println(quantity*price);
		    repo.save(o);
		    //return o.getPrice();
		    return -1;
	    
		
		
	}

	public List<Order> findById(int id) {
		
		return repo.findByUid(id);
		//List<Item> prod=new ArrayList<>();
//		for(Order ord:l)
//		{
//			int d=ord.getPid();
//			String url="http://ADMIN-PRODUCTS/product/get/"+d;
//			Item item=restTemplate.getForObject(url,Item.class);
//			prod.add(item);
//		}
	
		
		
		
	
	}



}

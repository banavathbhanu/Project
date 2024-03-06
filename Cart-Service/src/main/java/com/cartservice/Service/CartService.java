package com.cartservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import com.cartservice.Repository.Cartrepository;
import com.cartservice.entity.Addcart;
import com.cartservice.entity.Cart;
import com.cartservice.entity.Item;



@Service
public class CartService {
	
	@Autowired
	Cartrepository repo;
	@Autowired
	private RestTemplate restTemplate;
	
	public Long total(int uid,String username,String address,String contact)
	{
		long tp=0;
		System.out.println("hi");
		String url="http://ADDCART-SERVICE/addto/get/"+uid;
		ResponseEntity<Addcart[]> items=restTemplate.getForEntity(url,Addcart[].class);
		Addcart[] it=items.getBody();
		System.out.println(it);
		
		for(int i=0;i<it.length;i++)
		{
		Cart ca=new Cart();
		ca.setUid(uid);	
		ca.setPid(it[i].getPid());
		//ca.setSize(it[i].getSize());
		ca.setPrice(it[i].getPrice());
		ca.setQuantity(it[i].getQuantity());
//		String u="http://ADMIN-PRODUCTS/product/get/"+it[i].getPid();
//		Item item=restTemplate.getForObject(u,Item.class);
		ca.setImage(it[i].getImage());
		String ur="http://ADMIN-PRODUCTS/product/update/"+it[i].getPid()+"/"+it[i].getQuantity();
	    int s=restTemplate.exchange(ur, HttpMethod.PUT,null,int.class).getBody();
		System.out.println(it[i]);
		tp=tp+it[i].getPrice();
		ca.setAddress(address);
		ca.setContact(contact);
		ca.setUsername(username);
		repo.save(ca);
		}
		
		
		
		return tp;
	}

	public List<Cart> findById(int id) {
		// TODO Auto-generated method stub
			
			return repo.findByUid(id);
	}

}

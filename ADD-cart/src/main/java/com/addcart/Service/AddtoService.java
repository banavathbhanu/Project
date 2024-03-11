package com.addcart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.addcart.entity.*;
import com.addcart.Repository.AddtoRepository;


@Service
public class AddtoService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AddtoRepository repo;

	public long updateandaddtocart(int pid,int uid,int quantity) {
		// TODO Auto-generated method stub
		
		String url="http://ADMIN-PRODUCTS/product/updatecheck/"+pid+"/"+quantity;
	    int s=restTemplate.exchange(url, HttpMethod.PUT,null,int.class).getBody();
	    if(s!=1)
	    {
	    	return s;
	    }
	    String url1="http://ADMIN-PRODUCTS/product/get/"+pid;
		Item item=restTemplate.getForObject(url1,Item.class);
		Addcart order=new Addcart();
		order.setPid(pid);
		order.setUid(uid);
		order.setImage(item.getImage());
		order.setOrprice(item.getPrice());
	    long price=item.getPrice();
	    order.setQuantity(quantity);
	   // order.setSize(size);
	    order.setPrice(quantity*price);
	    System.out.println(quantity*price);
	    repo.save(order);
		return -1;
		
	}

	public long gettotal(int id) {
		// TODO Auto-generated method stub
		List<Addcart> add=repo.getitemsbyuid(id);
		long totalPrice=0;
		for(Addcart a:add)
		{
			totalPrice=totalPrice+a.getPrice();
		}
		return totalPrice;
	}

	public int getprice(int id) {
		// TODO Auto-generated method stub
		List<Addcart> add=repo.findByPid(id);
		int price=0;
		for(Addcart c:add)
		{
			price=c.getOrderprice();
			break;
		}
		return price;
	}
	public String updatecartprice(int id,int price) {
		// TODO Auto-generated method stub
		List<Addcart> add=repo.findByPid(id);
//		String url="http://ADMIN-PRODUCTS/product/get/"+id;
//		Item item=restTemplate.getForObject(url,Item.class);
		int v=0,m=0,z=0;
		
		for(Addcart cart:add)
		{
			cart.setOrprice(price);
			m=cart.getQuantity();
			cart.setPrice(m*price);
			repo.save(cart);
		}
		return "updated";
	}

	public int getproduct(int pid) {
		// TODO Auto-generated method stub
		List<Addcart> product= repo.findByPid(pid);
		System.out.println(product);
		/*if(p.size()>0)
		{
			return 1;
		}
		else
		{
			return 0;
		}*/
		return pid;
	}

}

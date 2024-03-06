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

	public long fun(int pid,int uid,int quantity) {
		// TODO Auto-generated method stub
		System.out.println("hiii");
		String u="http://ADMIN-PRODUCTS/product/updatecheck/"+pid+"/"+quantity;
	    int s=restTemplate.exchange(u, HttpMethod.PUT,null,int.class).getBody();
	    if(s!=1)
	    {
	    	return s;
	    }
	    String url="http://ADMIN-PRODUCTS/product/get/"+pid;
		Item item=restTemplate.getForObject(url,Item.class);
		Addcart o=new Addcart();
		o.setPid(pid);
		o.setUid(uid);
		o.setImage(item.getImage());
		o.setOrprice(item.getPrice());
	    long price=item.getPrice();
	    o.setQuantity(quantity);
	   // o.setSize(size);
	    o.setPrice(quantity*price);
	    System.out.println(quantity*price);
	    repo.save(o);
		return -1;
		
	}

	public long gettotal(int id) {
		// TODO Auto-generated method stub
		List<Addcart> ad=repo.getitemsbyuid(id);
		long tp=0;
		for(Addcart a:ad)
		{
			tp=tp+a.getPrice();
		}
		return tp;
	}

	public int getprice(int id) {
		// TODO Auto-generated method stub
		List<Addcart> a=repo.findByPid(id);
		int v=0;
		for(Addcart c:a)
		{
			v=c.getOrprice();
			break;
		}
		return v;
	}
	public String updatecartprice(int id,int price) {
		// TODO Auto-generated method stub
		List<Addcart> a=repo.findByPid(id);
//		String url="http://ADMIN-PRODUCTS/product/get/"+id;
//		Item item=restTemplate.getForObject(url,Item.class);
		int v=0,m=0,z=0;
		
		for(Addcart c:a)
		{
			c.setOrprice(price);
			m=c.getQuantity();
			c.setPrice(m*price);
			repo.save(c);
		}
		return "updated";
	}

	public int getproduct(int pid) {
		// TODO Auto-generated method stub
		List<Addcart> p= repo.findByPid(pid);
		System.out.println(p);
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

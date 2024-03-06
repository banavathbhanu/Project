package com.Productimage.Service;



import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.Productimage.Repository.ProductRepository;
import com.Productimage.exception.Productnotfoundexception;
import com.Productimage.model.Product;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	@Autowired
	ProductRepository prorepo;
	
	public void saveProduct(MultipartFile image,String itemname,String homemakername,int price,int availability) throws IOException {
		Product product=new Product();
		product.setImage(image.getBytes());
		product.setitemname(itemname);
		product.sethomemakername(homemakername);
		product.setPrice(price);
		product.setAvailability(availability);
		//log.info("Product saved ");
        prorepo.save(product);
		
	}
	public String updateProductId(int id,MultipartFile image,String itemname,String homemakername,int price,int availability) throws IOException
	{
		Product produ=prorepo.findById(id);
		if(produ==null)
		{
			return "0";
		}
		produ.setImage(image.getBytes());
		produ.setitemname(itemname);
		produ.sethomemakername(homemakername);
		produ.setPrice(price);
		produ.setAvailability(availability);
		prorepo.save(produ);
		return "Product updated";
		
	}
    public Page<Product> findProductWithPagination(int offset,int pagesize)
    {
    	Page<Product> products=prorepo.findAll(PageRequest.of(offset,pagesize));
    	return products;
    }
	public Page<Product> getPaginatedProducts(Pageable pageable) {
		// TODO Auto-generated method stub
		return prorepo.findAll(pageable);
	}
	public int updateProductavail(int pid,int quantity) {
		// TODO Auto-generated method stub
		Product pro=prorepo.findById(pid);
		int avail=pro.getAvailability();
		if(quantity>avail)
		{
			return avail;
		}
		int m=avail-quantity;
		pro.setAvailability(m);
		prorepo.save(pro);
		return 1;
		
	}
	public long getPrice(int id) {
		// TODO Auto-generated method stub
		Product pro=prorepo.findById(id);
		
		return pro.getPrice();
	}
	public String deleteproduct(int id) {
		// TODO Auto-generated method stub
		try
		 {
			 Product p = prorepo.findById(id);
			 if(p==null)
			 {
				 throw new Exception();
			 }
			  prorepo.delete(p);
			  

		        return "deleted";
		 }
		 catch(Exception e)
		 {
			return e.getMessage();
		 }
	}
	public int updatequantitycheck(int pid, int quantity) {
		// TODO Auto-generated method stub
		Product pro=prorepo.findById(pid);
		int avail=pro.getAvailability();
		if(quantity>avail)
		{
			return avail;
		}
		return 1;
	}
	public List<Product> findAllproducts() {
		// TODO Auto-generated method stub
		return prorepo.findAll();
	}
	public Product findByid(int id) throws Productnotfoundexception{
		// TODO Auto-generated method stub
		Product product= prorepo.findById(id);
		if(product==null)
		{
			throw new Productnotfoundexception("Product not found");
		}
		else
		{
			return product;
		}
	}
	public int getavailability(int id) {
		// TODO Auto-generated method stub
		Product product=prorepo.findById(id);
		return product.getAvailability();
	}

}

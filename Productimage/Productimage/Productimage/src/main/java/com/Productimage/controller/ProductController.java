package com.Productimage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.Productimage.Repository.ProductRepository;
import com.Productimage.Service.ProductService;
import com.Productimage.exception.Productnotfoundexception;
import com.Productimage.model.Product;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository prorepo;
	
	@Autowired
	ProductService proService;
	
	@PostMapping(value="/in",consumes="multipart/form-data")
	public String AddPro( @RequestParam("image") MultipartFile image,
			           @RequestParam("itemname") String itemname,
			           @RequestParam("homemakername") String homemakername,
			           @RequestParam("price") int price,
			           @RequestParam("availability") int availability) throws IOException
	{
		System.out.println("hi");
		    proService.saveProduct(image,itemname,homemakername,price,availability);
		    return "yes";
	}
	
	@GetMapping
	public List<com.Productimage.model.Product> getProdut(){
		return proService.findAllproducts();
	

}
	@GetMapping("/pagination")
	public ResponseEntity<Page<Product>> getPaginatedItems(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="5") int size)
	{
		Pageable pageable=PageRequest.of(page,size);
		Page<Product> propage=proService.getPaginatedProducts(pageable);
		return ResponseEntity.ok(propage);

		
	}
	@GetMapping("/get/{id}")
	public Product getProductbyid(@PathVariable("id") int id) throws Productnotfoundexception
	{
		Product product=proService.findByid(id);
		return product;
	}
	@GetMapping("/getavailability/{id}")
	public int getavailability(@PathVariable("id") int id)
	{
		return proService.getavailability(id);
	}
	@PutMapping(value="/{id}",consumes="multipart/form-data")
	public String updateProduct(@PathVariable("id") int id,@RequestParam("image") MultipartFile image,
	           @RequestParam("itemname") String itemname,
	           @RequestParam("homemakername") String homemakername,
	           @RequestParam("price") int price,
	           @RequestParam("availability") int availability) throws IOException{
        
        return proService.updateProductId(id,image,itemname,homemakername,price,availability);
    }
	@PutMapping("/update/{pid}/{qunatity}")
	public int updateAvailability(@PathVariable("pid") int pid,@PathVariable int qunatity) {
		return proService.updateProductavail(pid,qunatity);
	}
	@PutMapping("/updatecheck/{pid}/{qunatity}")
	public int updatecheck(@PathVariable("pid") int pid,@PathVariable int qunatity) {
		return proService.updatequantitycheck(pid,qunatity);
	}
	 @DeleteMapping("/{id}")
	    public String deleteProduct(@PathVariable int id){
//		 try
//		 {
//			 Product p = prorepo.findById(id);
//			 if(p==null)
//			 {
//				 throw new Exception();
//			 }
//			  prorepo.delete(p);
//			  
//
//		        return "deleted";
//		 }
//		 catch(Exception e)
//		 {
//			return e.getMessage();
//		 }
		 String x=proService.deleteproduct(id);
		 return x;

	    }
	 @GetMapping("/getPrice/{id}")
	 public long getPrice(@PathVariable int id)
	 {
		 return proService.getPrice(id);
	 }
	}

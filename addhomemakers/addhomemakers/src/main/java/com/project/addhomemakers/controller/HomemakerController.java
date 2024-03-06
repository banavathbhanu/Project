package com.project.addhomemakers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.addhomemakers.entity.Homemaker;
import com.project.addhomemakers.service.HomemakerService;

@RestController
public class HomemakerController {
	
	@Autowired
	HomemakerService hmservice;
	
	@PostMapping("/save")
	public Homemaker saveHomemaker(@RequestBody Homemaker hmaker) {
		return hmservice.save(hmaker);
	}
	
	@PutMapping("/edit")
	public Homemaker editHomemaker(@RequestBody Homemaker hmaker) {
		return hmservice.edit(hmaker);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
		hmservice.deleteHomemaker(id);
	}
	
	@GetMapping("/getcustomer")
	public Optional<Homemaker> getHomemaker(@RequestParam int id) {
		return hmservice.findHomemaker(id);
	}
	
	@GetMapping("/allcustomers")
	public List<Homemaker> getAllCustomers(){
		return hmservice.allHomemakers();
	}
	
}

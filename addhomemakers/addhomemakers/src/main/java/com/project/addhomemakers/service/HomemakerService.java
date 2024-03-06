package com.project.addhomemakers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.addhomemakers.entity.Homemaker;
import com.project.addhomemakers.repository.Homemakerrepo;

@Service
public class HomemakerService {
	
	@Autowired
	Homemakerrepo hmrepo;
	
	public Homemaker save(Homemaker hmaker) {
		return hmrepo.save(hmaker);
	}
	
	public Homemaker edit(Homemaker hmaker) {
		return hmrepo.save(hmaker);
	}
	
	public Optional<Homemaker> findHomemaker(int id) {
		return hmrepo.findById(id);
	}
	
	public void deleteHomemaker(int id) {
		hmrepo.deleteById(id);
	}
	
	public List<Homemaker> allHomemakers(){
		return hmrepo.findAll();
	}
}

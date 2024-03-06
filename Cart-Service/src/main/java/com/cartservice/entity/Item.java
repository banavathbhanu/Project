package com.cartservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;



public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id ;
    @Lob
    private byte[] image;
    private String itemname;
    private String homemakername;
    private int price;
    private int availability;
    
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getitemname() {
		return itemname;
	}
	public void setitemname(String itemname) {
		this.itemname = itemname;
	}
	public String gethomemakername() {
		return homemakername;
	}
	public void sethomemakername(String homemakername) {
		this.homemakername = homemakername;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    
	

	
    
}

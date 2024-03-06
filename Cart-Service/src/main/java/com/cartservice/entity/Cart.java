package com.cartservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cid;
	int uid;
	String username;
	String address;
	String contact;
	int quantity;
	//int size;
	long price;
	int pid;
	@Lob
	private byte[] image;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Cart(int cid, int uid, String username, String address, String contact, int quantity, long price,
			int pid, byte[] image) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.username = username;
		this.address = address;
		this.contact = contact;
		this.quantity = quantity;
		//this.size = size;
		this.price = price;
		this.pid = pid;
		this.image = image;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/*public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}*/
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

package com.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
//import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="order1")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int pid;
	private int uid;
    private String username;
    private String address;
    private String contact;
    private int quantity;
    private long price;
   // private int size;
    @Lob
    private byte[] image;
	/*public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}*/
	public Order() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Order(int id, int pid, int uid, String username, String address, String contact, int quantity, long price,
			 byte[] image) {
		super();
		this.id = id;
		this.pid = pid;
		this.uid = uid;
		this.username = username;
		this.address = address;
		this.contact = contact;
		this.quantity = quantity;
		this.price = price;
		//this.size = size;
		this.image = image;
	}
	
	
}
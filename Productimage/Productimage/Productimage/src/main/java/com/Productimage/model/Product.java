package com.Productimage.model;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Min;

@Entity
public class Product {
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(int id, byte[] image, String itemname, String homemakername, int price, int availability) {
		super();
		this.id = id;
		this.image = image;
		this.itemname = itemname;
		this.homemakername = homemakername;
		this.price = price;
		this.availability = availability;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", image=" + Arrays.toString(image) + ", itemname=" + itemname
				+ ", homemakername=" + homemakername + ", price=" + price + ", availability=" + availability + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	       private int id ;
	       @Lob
	       private byte[] image;
	       private String itemname;
	       private String homemakername;
	       @Min(value=1,message="Value should be greater 1")
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

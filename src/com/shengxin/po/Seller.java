package com.shengxin.po;

public class Seller {
	private int id;
	private String name;
	private String address;
	private String picUrl;
	private String phone;
	private String restaurantHours;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRestaurantHours() {
		return restaurantHours;
	}

	public void setRestaurantHours(String restaurantHours) {
		this.restaurantHours = restaurantHours;
	}

}

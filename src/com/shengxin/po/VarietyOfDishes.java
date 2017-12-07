package com.shengxin.po;

public class VarietyOfDishes {
	private int id;
	private String name;
	private String picUrl;
	private Double originalPrice;
	private Double presentPrice;
	private int class_id;
	private String className;
	private int seller_id;
	private String sellerName;
	private boolean favouravle;
	private int soldNum;
	private int scannedNum;

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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getPresentPrice() {
		return presentPrice;
	}

	public void setPresentPrice(Double presentPrice) {
		this.presentPrice = presentPrice;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public boolean isFavouravle() {
		return favouravle;
	}

	public void setFavouravle(boolean favouravle) {
		this.favouravle = favouravle;
	}

	public int getSoldNum() {
		return soldNum;
	}

	public void setSoldNum(int soldNum) {
		this.soldNum = soldNum;
	}

	public int getScannedNum() {
		return scannedNum;
	}

	public void setScannedNum(int scannedNum) {
		this.scannedNum = scannedNum;
	}

}

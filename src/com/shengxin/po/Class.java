package com.shengxin.po;

public class Class {
	private int id;
	private int sellerId;
	private String chineseName;
	private String englishName;
	private String picUrl;
	private Boolean bannerShow;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Boolean getBannerShow() {
		return bannerShow;
	}

	public void setBannerShow(Boolean bannerShow) {
		this.bannerShow = bannerShow;
	}

}

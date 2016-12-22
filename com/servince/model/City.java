package com.servince.model;

public class City {
	private int id;
	private String cityID;
	private String city;
	private Province pro;

	public Province getPro() {
		return pro;
	}

	public void setPro(Province pro) {
		this.pro = pro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

package com.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ScreenEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String id;
	private String screenNumber;
	private String classic;
	private String classicPlus;
	private String prime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getScreenNumber() {
		return screenNumber;
	}
	public void setScreenNumber(String screenNumber) {
		this.screenNumber = screenNumber;
	}
	public String getClassic() {
		return classic;
	}
	public void setClassic(String classic) {
		this.classic = classic;
	}
	public String getClassicPlus() {
		return classicPlus;
	}
	public void setClassicPlus(String classicPlus) {
		this.classicPlus = classicPlus;
	}
	public String getPrime() {
		return prime;
	}
	public void setPrime(String prime) {
		this.prime = prime;
	}
}

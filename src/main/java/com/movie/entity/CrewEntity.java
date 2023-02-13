package com.movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CrewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer crewId;
	private String name;
	private String role;
	private String image;
	@Column(columnDefinition ="LONGTEXT")
	private String imageData;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
	public String getImageData() {
		return imageData;
	}
	public Integer getCrewId() {
		return crewId;
	}
	public void setCrewId(Integer crewId) {
		this.crewId = crewId;
	}
	
}

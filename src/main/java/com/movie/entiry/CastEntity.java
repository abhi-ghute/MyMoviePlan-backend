package com.movie.entiry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CastEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer castID;
	private String name;
	private String movieName;
	private String image;
	@Column(columnDefinition ="LONGTEXT")
	private String imageData;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
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
	public Integer getCastID() {
		return castID;
	}
	public void setCastID(Integer castID) {
		this.castID = castID;
	}
}

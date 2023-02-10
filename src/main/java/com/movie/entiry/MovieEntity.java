package com.movie.entiry;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String classicPrice;
	private String classicPlusPrice;
	private String primePrice;
	private String type;
	private String language;
	private String description;
	private String image;
	private String releaseDate;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id")
	private List<CastEntity> cast;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id")
	private List<CrewEntity> crew;
	private String visuals;
	private String status="enable";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassicPrice() {
		return classicPrice;
	}
	public void setClassicPrice(String classicPrice) {
		this.classicPrice = classicPrice;
	}
	public String getClassicPlusPrice() {
		return classicPlusPrice;
	}
	public void setClassicPlusPrice(String classicPlusPrice) {
		this.classicPlusPrice = classicPlusPrice;
	}
	public String getPrimePrice() {
		return primePrice;
	}
	public void setPrimePrice(String primePrice) {
		this.primePrice = primePrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<CastEntity> getCast() {
		return cast;
	}
	public void setCast(List<CastEntity> cast) {
		this.cast = cast;
	}
	public List<CrewEntity> getCrew() {
		return crew;
	}
	public void setCrew(List<CrewEntity> crew) {
		this.crew = crew;
	}
	public String getVisuals() {
		return visuals;
	}
	public void setVisuals(String visuals) {
		this.visuals = visuals;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
}

package com.movie.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TicketDetails {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String mid;
	    private String sid;
	    private String uid;
	    private Integer totalCost;
	    private List<String> selectedSeats;
	    
		public Integer getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(Integer totalCost) {
			this.totalCost = totalCost;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getMid() {
			return mid;
		}
		public void setMid(String mid) {
			this.mid = mid;
		}
		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public List<String> getSelectedSeats() {
			return selectedSeats;
		}
		public void setSelectedSeats(List<String> selectedSeats) {
			this.selectedSeats = selectedSeats;
		}
}

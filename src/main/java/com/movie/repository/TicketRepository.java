package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.TicketDetails;

@Repository
public interface TicketRepository extends JpaRepository<TicketDetails, Integer>{

	public List<TicketDetails> findByUid(String uid);
	public List<TicketDetails> findBySid(String sid);
}

package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.ShowEntity;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Integer>{

	public ShowEntity findById(String id);
}


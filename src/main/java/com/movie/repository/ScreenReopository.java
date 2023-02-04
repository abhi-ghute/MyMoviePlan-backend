package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entiry.ScreenEntity;

@Repository
public interface ScreenReopository extends JpaRepository<ScreenEntity, Integer> {

	public ScreenEntity findByScreenNumber(String screen);
}

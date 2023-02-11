package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entiry.ShowEntity;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Integer>{

}


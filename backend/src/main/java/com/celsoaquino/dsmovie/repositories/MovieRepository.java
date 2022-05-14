package com.celsoaquino.dsmovie.repositories;

import com.celsoaquino.dsmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

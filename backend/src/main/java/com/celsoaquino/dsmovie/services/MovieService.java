package com.celsoaquino.dsmovie.services;

import com.celsoaquino.dsmovie.dto.MovieDTO;
import com.celsoaquino.dsmovie.entities.Movie;
import com.celsoaquino.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> list = movieRepository.findAll(pageable);
        Page<MovieDTO> page = list.map(x -> new MovieDTO(x));
        return page;
    }

    public MovieDTO findById(Long id) {
        Movie result = movieRepository.findById(id).get();
        MovieDTO dto = new MovieDTO(result);
        return dto;
    }
}

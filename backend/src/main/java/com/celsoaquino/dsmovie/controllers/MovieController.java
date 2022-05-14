package com.celsoaquino.dsmovie.controllers;

import com.celsoaquino.dsmovie.dto.MovieDTO;
import com.celsoaquino.dsmovie.services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Page<MovieDTO> findAll(Pageable pageable) {
        return movieService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public MovieDTO findById(@PathVariable Long id) {
        return movieService.findById(id);
    }
}

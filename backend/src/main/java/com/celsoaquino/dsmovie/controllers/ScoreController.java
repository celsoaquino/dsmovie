package com.celsoaquino.dsmovie.controllers;

import com.celsoaquino.dsmovie.dto.MovieDTO;
import com.celsoaquino.dsmovie.dto.ScoreDTO;
import com.celsoaquino.dsmovie.services.ScoreService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }


    @PutMapping()
    public MovieDTO SaveScore(@RequestBody ScoreDTO scoreDTO) {
        var dto = scoreService.saveScore(scoreDTO);
        return dto;
    }
}

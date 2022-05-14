package com.celsoaquino.dsmovie.services;

import com.celsoaquino.dsmovie.dto.MovieDTO;
import com.celsoaquino.dsmovie.dto.ScoreDTO;
import com.celsoaquino.dsmovie.entities.Score;
import com.celsoaquino.dsmovie.entities.User;
import com.celsoaquino.dsmovie.repositories.MovieRepository;
import com.celsoaquino.dsmovie.repositories.ScoreRepository;
import com.celsoaquino.dsmovie.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private ScoreRepository scoreRepository;

    public ScoreService(MovieRepository movieRepository, UserRepository userRepository, ScoreRepository scoreRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){
        var user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        var movie = movieRepository.findById(dto.getMovieId()).get();

        var score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum += s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}

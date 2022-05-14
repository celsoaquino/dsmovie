package com.celsoaquino.dsmovie.repositories;

import com.celsoaquino.dsmovie.entities.Score;
import com.celsoaquino.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}

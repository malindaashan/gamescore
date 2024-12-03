package com.rootcode.gamescore.service;

import com.rootcode.gamescore.domain.Score;
import com.rootcode.gamescore.model.UserScoreDto;
import com.rootcode.gamescore.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    UserService userService;
    public Boolean saveScore(UserScoreDto userScoreDto) throws IllegalArgumentException{
        Score score = new Score();
        score.setUser(userService.getUserById(userScoreDto.getUserId()));
        score.setScore(userScoreDto.getScore());
        scoreRepository.save(score);
        return Boolean.TRUE;
    }
}

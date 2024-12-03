package com.rootcode.gamescore.service;

import com.rootcode.gamescore.domain.Score;
import com.rootcode.gamescore.model.MaxScoreDto;
import com.rootcode.gamescore.model.ScoreDto;
import com.rootcode.gamescore.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;

    public Boolean saveScore(ScoreDto userScoreDto) throws IllegalArgumentException {
        Score score = new Score();
        score.setUser(userService.getUserById(userScoreDto.getUserId()));
        score.setGame(gameService.getByGameId(userScoreDto.getGameId()));
        score.setScore(userScoreDto.getScore());
        scoreRepository.save(score);
        return Boolean.TRUE;
    }

    public List<Score> getTop10ByGame(Long gameId) {
        return scoreRepository.findTop10ScoresByGame(gameService.getByGameId(gameId));
    }

    public List<MaxScoreDto> getUserHighestScore(Long userId) {

        return scoreRepository.findTopScoresByUser(userService.getUserById(userId)).stream()
                .map(row -> new MaxScoreDto(
                        ((Number) row[0]).longValue(),  // gameId
                        ((Double) row[1]).doubleValue()   // score
                ))
                .collect(Collectors.toList());
    }
}

package com.rootcode.gamescore.controller;

import com.rootcode.gamescore.model.ApiResponse;
import com.rootcode.gamescore.model.UserScoreDto;
import com.rootcode.gamescore.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/score")
@Slf4j
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping
    public ApiResponse saveUserScore(@RequestBody UserScoreDto userScoreDto) {
        log.info("Entered saveUserScore with userId:{} and gameId:{}", userScoreDto.getUserId(), userScoreDto.getGameId());
        try {
            return new ApiResponse(scoreService.saveScore(userScoreDto));
        } catch (IllegalArgumentException e) {
            log.error("saveUserScore Failed:{}",e.getMessage());
            return new ApiResponse("Error while saving score", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/top10")
    public ApiResponse getTop10ByGame(@RequestParam Long gameId){
        return new ApiResponse(scoreService.getTop10ByGame(gameId));
    }

    @GetMapping("/user")
    public ApiResponse getUserHighestScore(@RequestParam Long userId){
        return new ApiResponse(scoreService.getUserHighestScore(userId));
    }
}

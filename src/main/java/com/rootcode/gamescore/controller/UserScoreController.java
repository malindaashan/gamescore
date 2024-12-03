package com.rootcode.gamescore.controller;

import com.rootcode.gamescore.model.ApiResponse;
import com.rootcode.gamescore.model.UserScoreDto;
import com.rootcode.gamescore.service.UserScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/userscore")
@Slf4j
public class UserScoreController {

    @Autowired
    UserScoreService userScoreService;

    @PostMapping
    public ApiResponse saveUserScore(@RequestBody UserScoreDto userScoreDto) {
        log.info("Entered saveUserScore with userId:{} and gameId:{}", userScoreDto.getUserId(), userScoreDto.getGameId());
        try {
            return new ApiResponse(userScoreService.saveScore(userScoreDto));
        } catch (IllegalArgumentException e) {
            return new ApiResponse("Error while saving score", e.getCause());
        }
    }
}

package com.rootcode.gamescore.model;

import lombok.Data;

@Data
public class MaxScoreDto {
    private Long gameId;
    private Double score;


    public MaxScoreDto(Long gameId, Double score) {
        this.gameId = gameId;
        this.score = score;
    }
}

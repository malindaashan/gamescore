package com.rootcode.gamescore.model;

import lombok.Data;

@Data
public class ScoreDto {
    private long userId;
    private long gameId;
    private Double score;
}

package com.rootcode.gamescore.model;

import lombok.Data;

@Data
public class UserScoreDto {
    private long userId;
    private long gameId;
    private Double score;
}

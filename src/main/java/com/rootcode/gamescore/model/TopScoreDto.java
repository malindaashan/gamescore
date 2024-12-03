package com.rootcode.gamescore.model;

import lombok.Data;

import java.util.List;
@Data
public class TopScoreDto {

    private long gameId;
    private List<Double> scoreList;
}

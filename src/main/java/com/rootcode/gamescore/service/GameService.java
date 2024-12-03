package com.rootcode.gamescore.service;

import com.rootcode.gamescore.domain.Game;
import com.rootcode.gamescore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public Game getByGameId(long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        return game.orElseThrow(() -> new IllegalArgumentException("Game not found"));
    }
}

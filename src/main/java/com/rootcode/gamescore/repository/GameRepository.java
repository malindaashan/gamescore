package com.rootcode.gamescore.repository;

import com.rootcode.gamescore.domain.Game;
import com.rootcode.gamescore.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

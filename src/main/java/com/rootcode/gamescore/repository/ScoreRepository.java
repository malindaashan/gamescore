package com.rootcode.gamescore.repository;

import com.rootcode.gamescore.domain.Game;
import com.rootcode.gamescore.domain.Score;
import com.rootcode.gamescore.domain.User;
import com.rootcode.gamescore.model.MaxScoreDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT s.game.id as gameId, max(s.score) as score FROM Score s WHERE s.user = :user group by  s.game")
    List<Object[]> findTopScoresByUser(@Param("user") User user);

    @Query("SELECT s FROM Score s WHERE s.game = :game ORDER BY s.score DESC LIMIT 10")
    List<Score> findTop10ScoresByGame(@Param("game") Game game);
}

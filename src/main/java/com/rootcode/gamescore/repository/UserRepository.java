package com.rootcode.gamescore.repository;

import com.rootcode.gamescore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

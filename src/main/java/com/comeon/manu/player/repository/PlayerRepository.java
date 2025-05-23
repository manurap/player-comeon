package com.comeon.manu.player.repository;

import com.comeon.manu.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository  extends JpaRepository<Player, Long> {
    Optional<Player> findByEmail(String email);

}

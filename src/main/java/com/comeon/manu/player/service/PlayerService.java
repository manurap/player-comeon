package com.comeon.manu.player.service;

import com.comeon.manu.player.entity.Player;
import com.comeon.manu.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Player> findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    public Player save(Player player) {
        player.setPassword(passwordEncoder.encode(player.getPassword())); // Secure password
        return playerRepository.save(player);
    }

    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

}

package com.comeon.manu.player.controller;

import com.comeon.manu.player.dto.PlayerRequest;
import com.comeon.manu.player.entity.Player;
import com.comeon.manu.player.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Player> registerPlayer(@RequestBody @Valid PlayerRequest playerRequest) {
        Player player = new Player();
        player.setEmail(playerRequest.email());
        player.setPassword(playerRequest.password());
        player.setFirstName(playerRequest.firstName());
        player.setLastName(playerRequest.lastName());

        return ResponseEntity.ok(playerService.save(player));
    }


}

package com.comeon.manu.player.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

public class Session {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private boolean sessionActive;
}

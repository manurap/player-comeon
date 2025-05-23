package com.comeon.manu.player;

import org.springframework.boot.SpringApplication;

public class TestPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.from(PlayerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

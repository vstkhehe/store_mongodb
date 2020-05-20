package com.lightninggames.store.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lightninggames.store.domain.Game;
import com.lightninggames.store.repository.GameRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		gameRepository.deleteAll();
		
		Game madmax = new Game(null, "Mad Max", null, "Steam", "39.90", 1);
		Game sniperelite = new Game(null, "Sniper Elite", null, "Steam", "39.90", 1);
		
		gameRepository.saveAll(Arrays.asList(madmax, sniperelite));
		
	}

}

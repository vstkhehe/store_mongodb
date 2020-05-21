package com.lightninggames.store.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lightninggames.store.DTO.AuthorDTO;
import com.lightninggames.store.domain.Game;
import com.lightninggames.store.domain.Post;
import com.lightninggames.store.repository.GameRepository;
import com.lightninggames.store.repository.PostRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		gameRepository.deleteAll();
		postRepository.deleteAll();
		
		Game madmax = new Game(null, "Mad Max", null, "Steam", "39.90", 1);
		Game sniperelite = new Game(null, "Sniper Elite", null, "Steam", "39.90", 1);
		
		gameRepository.saveAll(Arrays.asList(madmax, sniperelite));

		
		Post post1 = new Post (null, sdf.parse("21/05/2020"), "Mad Max", "Promoção", new AuthorDTO(madmax));
		
		postRepository.saveAll(Arrays.asList(post1));
	}

}

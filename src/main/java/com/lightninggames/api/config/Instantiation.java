package com.lightninggames.api.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lightninggames.api.DTO.AuthorDTO;
import com.lightninggames.api.DTO.CommentDTO;
import com.lightninggames.api.domain.Game;
import com.lightninggames.api.domain.Post;
import com.lightninggames.api.repository.GameRepository;
import com.lightninggames.api.repository.PostRepository;

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
		
		CommentDTO key = new CommentDTO("3123-ASDASD-21321-ASDSD", sdf.parse("21/05/2020"), new AuthorDTO(madmax));
		CommentDTO key2 = new CommentDTO("1234-KHJK-6554-VCZCX", sdf.parse("21/05/2020"), new AuthorDTO(madmax));
				
		post1.getComments().addAll(Arrays.asList(key, key2));
		
		postRepository.saveAll(Arrays.asList(post1));
		
		madmax.getPosts().addAll(Arrays.asList(post1));
		gameRepository.save(madmax);
	}

}

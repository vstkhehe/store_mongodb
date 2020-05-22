package com.lightninggames.store.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lightninggames.store.domain.Post;
import com.lightninggames.store.repository.PostRepository;
import com.lightninggames.store.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Optional<Post> findById(String id){
		Optional<Post> game = repo.findById(id);
		if(game.isEmpty()) {
			throw new ObjectNotFoundException("Jogo não encontrado");
		}
		return game;
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}

}

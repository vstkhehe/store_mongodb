package com.lightninggames.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lightninggames.store.domain.Game;
import com.lightninggames.store.repository.GameRepository;
import com.lightninggames.store.services.exception.ObjectNotFoundException;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repo;
	
	public List<Game> findAll(){
		return repo.findAll();
	}
	
	public Optional<Game> findById(String id){
		Optional<Game> game = repo.findById(id);
		if(game.isEmpty()) {
			throw new ObjectNotFoundException("Jogo não encontrado");
		}
		return game;
	}
}

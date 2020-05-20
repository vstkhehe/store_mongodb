package com.lightninggames.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lightninggames.store.domain.Game;
import com.lightninggames.store.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repo;
	
	public List<Game> findAll(){
		return repo.findAll();
	}
}

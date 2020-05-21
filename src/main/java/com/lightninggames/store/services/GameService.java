package com.lightninggames.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lightninggames.store.DTO.GameDTO;
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
	
	public Game insert(Game obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id); 
		repo.deleteById(id);
	}
	
	public Game update(Game obj) {
		Game newObj = repo.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Game newObj, Game obj) {
		newObj.setKey(obj.getKey());
		newObj.setNome(obj.getNome());
		newObj.setPlatforma(obj.getPlataforma());
		newObj.setPreco(obj.getPreco());
		newObj.setDisponibilidade(obj.getDisponibilidade());		
	}

	public Game fromDTO(GameDTO objDTO){
		return new Game(objDTO.getId(), objDTO.getKey(), objDTO.getNome(), objDTO.getPlataforma(), objDTO.getPreco(), objDTO.getDisponibilidade());
	}
	
}

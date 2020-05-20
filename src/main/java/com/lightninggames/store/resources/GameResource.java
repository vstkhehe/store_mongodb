package com.lightninggames.store.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lightninggames.store.DTO.GameDTO;
import com.lightninggames.store.domain.Game;
import com.lightninggames.store.services.GameService;

@RestController
@RequestMapping(value="/games")
public class GameResource {
	
	@Autowired
	private GameService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GameDTO>> findAll(){
		List<Game> list = service.findAll();
		List<GameDTO> listDTO = list.parallelStream().map(x -> new GameDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}

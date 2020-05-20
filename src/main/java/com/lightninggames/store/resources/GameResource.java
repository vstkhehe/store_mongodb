package com.lightninggames.store.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lightninggames.store.domain.Game;
import com.lightninggames.store.services.GameService;

@RestController
@RequestMapping(value="/games")
public class GameResource {
	
	@Autowired
	private GameService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Game>> findAll(){
		List<Game> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}

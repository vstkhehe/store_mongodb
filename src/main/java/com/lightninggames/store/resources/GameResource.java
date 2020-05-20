package com.lightninggames.store.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lightninggames.store.domain.Game;

@RestController
@RequestMapping(value="/games")
public class GameResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Game>> findAll(){
		Game madmax = new Game("1", "mad max", "aaaa-1111-aaaaa-2222", "Steam", "50.00", "1");
		Game assassinscreed = new Game("2", "assassins creed 4", "aaaa-33333-bbbb-5555", "Steam", "30.00", "1");
		List<Game> list = new ArrayList<>();
		list.addAll(Arrays.asList(madmax, assassinscreed));
		return ResponseEntity.ok().body(list);
	}
}

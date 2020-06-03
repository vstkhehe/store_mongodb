package com.lightninggames.api.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lightninggames.api.DTO.GameDTO;
import com.lightninggames.api.domain.Game;
import com.lightninggames.api.domain.Post;
import com.lightninggames.api.services.GameService;

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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<GameDTO> findById(@PathVariable String id){
		Optional<Game> obj = service.findById(id);		
		return ResponseEntity.ok().body(new GameDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody GameDTO objDto){
		Game obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody GameDTO objDto, @PathVariable String id){
		Game obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		Optional<Game> obj = service.findById(id);		
		return ResponseEntity.ok().body(obj.get().getPosts());
	}
}

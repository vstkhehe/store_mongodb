package com.lightninggames.store.DTO;

import java.io.Serializable;

import com.lightninggames.store.domain.Game;

public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public AuthorDTO() {
		
	}
	
	public AuthorDTO(Game obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

}

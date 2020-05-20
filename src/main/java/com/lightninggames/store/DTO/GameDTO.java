package com.lightninggames.store.DTO;

import java.io.Serializable;
import java.util.Optional;

import com.lightninggames.store.domain.Game;

public class GameDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String key;
	private String plataforma;
	private String preco;
	private int disponibilidade;
	
	public GameDTO() {		
	}
	
	public GameDTO(Game obj) {
		id = obj.getId();
		nome = obj.getNome();
		key = obj.getKey();
		plataforma = obj.getPlataforma();
		preco = obj.getPreco();
		disponibilidade = obj.getDisponibilidade();
	}
	
	public GameDTO(Optional<Game> obj) {
		id = obj.get().getId();
		nome = obj.get().getNome();
		key = obj.get().getKey();
		plataforma = obj.get().getPlataforma();
		preco = obj.get().getPreco();
		disponibilidade = obj.get().getDisponibilidade();
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public int getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(int disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
}

package com.lightninggames.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lightninggames.store.domain.Game;

@Repository
public interface GameRepository extends MongoRepository<Game, String>{


}

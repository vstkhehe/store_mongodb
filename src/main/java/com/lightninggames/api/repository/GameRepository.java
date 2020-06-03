package com.lightninggames.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lightninggames.api.domain.Game;

@Repository
public interface GameRepository extends MongoRepository<Game, String>{


}

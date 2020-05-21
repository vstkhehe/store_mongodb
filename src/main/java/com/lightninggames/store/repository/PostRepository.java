package com.lightninggames.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lightninggames.store.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{


}

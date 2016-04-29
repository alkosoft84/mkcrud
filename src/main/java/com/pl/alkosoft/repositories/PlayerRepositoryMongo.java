package com.pl.alkosoft.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pl.alkosoft.model.PlayerMongo;

/**
 * Created by mwrobel on 29.09.15.
 */
public interface PlayerRepositoryMongo extends MongoRepository<PlayerMongo, String> {

}

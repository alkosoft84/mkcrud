package com.pl.alkosoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pl.alkosoft.model.PlayerJpa;

/**
 * Created by mwrobel on 29.09.15.
 */
public interface PlayerRepositoryJpa extends JpaRepository<PlayerJpa,String> {

}

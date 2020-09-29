package com.gamestore.demo.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.gamestore.demo.model.Game;

public interface GameRepository extends JpaRepositoryImplementation<Game, Integer> {

}

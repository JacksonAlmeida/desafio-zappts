package com.sunflower.zappts.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunflower.zappts.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

}
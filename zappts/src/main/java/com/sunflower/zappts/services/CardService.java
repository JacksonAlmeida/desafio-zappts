package com.sunflower.zappts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunflower.zappts.entities.Card;
import com.sunflower.zappts.entities.repositories.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	public List<Card> findAll() {
		List<Card> list = cardRepository.findAll();
		return list;
	}

	public Card insert(Card card) {
		return cardRepository.save(card);
	}
}

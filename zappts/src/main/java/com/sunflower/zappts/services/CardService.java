package com.sunflower.zappts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sunflower.zappts.entities.Card;
import com.sunflower.zappts.entities.repositories.CardRepository;
import com.sunflower.zappts.services.exceptions.DatabaseException;
import com.sunflower.zappts.services.exceptions.ResourceNotFoundException;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	public List<Card> findAll() {
		List<Card> list = cardRepository.findAll();
		return list;
	}

	public Card findById(Long id) {
		Optional<Card> obj = cardRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Card insert(Card card) {
		return cardRepository.save(card);
	}

	public void delete(Long id) {
		try {
			cardRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}

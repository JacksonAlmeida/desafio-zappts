package com.sunflower.zappts.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunflower.zappts.entities.Card;
import com.sunflower.zappts.entities.repositories.CardRepository;

@RestController
@RequestMapping(value = "api/cards")
public class CardResource {

	@Autowired
	private CardRepository cardRepository;

	@GetMapping
	public ResponseEntity<List<Card>> findAll() {
		List<Card> list = cardRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

}

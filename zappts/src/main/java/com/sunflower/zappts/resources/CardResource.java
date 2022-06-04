package com.sunflower.zappts.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sunflower.zappts.entities.Card;
import com.sunflower.zappts.services.CardService;

@RestController
@RequestMapping(value = "api/cards")
public class CardResource {

	@Autowired
	private CardService cardService;

	@GetMapping
	public ResponseEntity<List<Card>> findAll() {
		List<Card> cards = cardService.findAll();
		return ResponseEntity.ok().body(cards);
	}

	@PostMapping(value = "/newcard")
	public ResponseEntity<Card> save(@RequestBody Card obj) {
		obj = cardService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
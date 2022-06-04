package com.sunflower.zappts.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunflower.zappts.entities.Player;
import com.sunflower.zappts.entities.repositories.PlayerRepository;

@RestController
@RequestMapping(value = "api/players")
public class PlayerResource {

	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping
	public ResponseEntity<List<Player>> findAll() {
		List<Player> list = playerRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
}

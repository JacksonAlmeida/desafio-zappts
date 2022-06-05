package com.sunflower.zappts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunflower.zappts.entities.Player;
import com.sunflower.zappts.entities.repositories.PlayerRepository;
import com.sunflower.zappts.services.exceptions.ResourceNotFoundException;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	public Player findById(Long id) {
		Optional<Player> obj = playerRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Player insert(Player player) {
		return playerRepository.save(player);
	}

	public void delete(Long id) {
		playerRepository.deleteById(id);
	}

	public Player update(Long id, Player obj) {
		Player entity = playerRepository.getOne(id);
		updateData(entity, obj);
		return playerRepository.save(entity);
	}

	public Player updateData(Player entity, Player obj) {
		entity.setName(obj.getName());
		return playerRepository.save(entity);
	}
}

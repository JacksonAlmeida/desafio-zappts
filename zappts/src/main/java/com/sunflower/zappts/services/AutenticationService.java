package com.sunflower.zappts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sunflower.zappts.entities.Player;
import com.sunflower.zappts.entities.repositories.PlayerRepository;

@Service
public class AutenticationService implements UserDetailsService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Player> player = playerRepository.findByname(username);
		if (player.isPresent()) {
			return player.get();
		}
		throw new UsernameNotFoundException("Dados inválidos");
	}

}

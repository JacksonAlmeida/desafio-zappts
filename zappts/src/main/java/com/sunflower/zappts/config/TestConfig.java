package com.sunflower.zappts.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sunflower.zappts.entities.Card;
import com.sunflower.zappts.entities.Player;
import com.sunflower.zappts.entities.enums.CardsStatus;
import com.sunflower.zappts.entities.repositories.CardRepository;
import com.sunflower.zappts.entities.repositories.PlayerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private CardRepository cardRepository;

	@Override
	public void run(String... args) throws Exception {

		Card card = new Card(1, "Angelo", "2 edicao", "ingles", CardsStatus.LAMINATED, 22.05);
		Card card1 = new Card(2, "Gess", "2 edicao", "ingles", CardsStatus.LAMINATED, 22.05);
		Card card2 = new Card(3, "Crug", "5 edicao", "ingles", CardsStatus.NOLAMINATED, 10.05);
		Card card3 = new Card(4, "Triss", "4 edicao", "ingles", CardsStatus.NOLAMINATED, 15.05);
		cardRepository.saveAll(Arrays.asList(card, card1, card2, card3));
		
		Player p1 = new Player(1, "Jackson Almeida");
		playerRepository.save(p1);
		
		p1.getCards().add(card);
		p1.getCards().add(card1);
		p1.getCards().add(card2);
		p1.getCards().add(card3);
		
		playerRepository.save(p1);
	}

}

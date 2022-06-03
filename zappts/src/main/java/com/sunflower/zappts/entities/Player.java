package com.sunflower.zappts.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "tb_player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name = "tb_player_card",
	joinColumns = @JoinColumn(name = "player_id"),
	inverseJoinColumns = @JoinColumn(name = "card_id"))
	private Set<Card> cards = new HashSet<>();

	public Player() {
	}

	public Player(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Player(long id, String name, Set<Card> cards) {
		this.id = id;
		this.name = name;
		this.cards = cards;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
}

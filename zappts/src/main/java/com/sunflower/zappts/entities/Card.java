package com.sunflower.zappts.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sunflower.zappts.entities.enums.CardsStatus;

@Entity
@Table(name = "tb_card")
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String edition;
	private String idioma;
	private Double price;

	private Integer cardsStatus;

	@OneToMany(mappedBy = "id.player", fetch = FetchType.EAGER)
	private Set<ListCard> listPlayers = new HashSet<>();

	public Card() {
	}

	public Card(long id, String name, String edition, String idioma, CardsStatus cardsStatus, double price) {
		this.id = id;
		this.name = name;
		this.edition = edition;
		this.idioma = idioma;
		setCardsStatus(cardsStatus);
		this.price = price;
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

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public CardsStatus getCardsStatus() {
		return CardsStatus.valueOf(cardsStatus);
	}

	public void setCardsStatus(CardsStatus cardsStatus) {
		if (cardsStatus != null)
			this.cardsStatus = cardsStatus.getCode();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Player> getPlayes() {
		Set<Player> set = new HashSet<>();
		for (ListCard x : listPlayers) {
			set.add(x.getPlayer());
		}
		return set;
	}

}

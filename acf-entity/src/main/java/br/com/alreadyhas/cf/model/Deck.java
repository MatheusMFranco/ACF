package br.com.alreadyhas.cf.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.alreadyhas.cf.model.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Deck</h2>
 * <hr />
 * <p>This class represents the cards selects for User.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.ProfileChampion
 * @see br.com.alreadyhas.cf.model.Card
 *
 */
@Entity
public class Deck extends Model {

	private static final long serialVersionUID = 3429388085169326537L;

	/**
	 * @see br.com.alreadyhas.cf.model.ProfileChampion
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "DECK_USER", nullable = false)
	private ProfileChampion userDeck;

	/**
	 * @see br.com.alreadyhas.cf.model.Card
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "CARD", nullable = false)
	private Card cardDeck;

	public Deck() {/**/}

	public Deck(Long id) {
		super(id);
	}

	public Deck(ProfileChampion user, Card card) {
		this.userDeck = user;
		this.cardDeck = card;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cardDeck == null) ? 0 : cardDeck.hashCode());
		result = prime * result + ((userDeck == null) ? 0 : userDeck.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (cardDeck == null) {
			if (other.cardDeck != null)
				return false;
		} else if (!cardDeck.equals(other.cardDeck))
			return false;
		if (userDeck == null) {
			if (other.userDeck != null)
				return false;
		} else if (!userDeck.equals(other.userDeck))
			return false;
		return true;
	}

}

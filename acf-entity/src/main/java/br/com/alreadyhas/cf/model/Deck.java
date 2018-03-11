package br.com.alreadyhas.cf.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.alreadyhas.cf.contract.Model;
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
 * @see br.com.alreadyhas.cf.model.UserChampion
 * @see br.com.alreadyhas.cf.model.Card
 *
 */
@Entity
public class Deck extends Model {

	private static final long serialVersionUID = 3429388085169326537L;

	/**
	 * @see br.com.alreadyhas.cf.model.UserChampion
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "DECK_USER", nullable = false)
	private UserChampion user;

	/**
	 * @see br.com.alreadyhas.cf.model.Card
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "CARD", nullable = false)
	private Card card;

	public Deck() {/**/}

	public Deck(Long id) {
		super(id);
	}

	public Deck(UserChampion user, Card card) {
		this.user = user;
		this.card = card;
	}

}

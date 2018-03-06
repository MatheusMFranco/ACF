package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.alreadyhas.cf.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Card</h2>
 * <hr />
 * <p>
 * This class represents the card to form the deck in battle.
 * </p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.preset.CardTypeEnum * @see
 * @see br.com.alreadyhas.cf.preset.ElementEnum
 * @see br.com.alreadyhas.cf.model.Pet
 *
 */
@Entity
public class Card extends Model {

	private static final long serialVersionUID = -4348054744182289110L;

	@Getter
	@Setter
	@Column(name = "CARD_NAME", nullable = false)
	private String name;

	@Getter
	@Setter
	@Column(name = "CARD_DESCRIPTION", nullable = false)
	private String description;

	/**
	 * Set only ElementEnum values
	 * @see br.com.alreadyhas.cf.model.ElementEnum
	 **/
	@Getter
	@Setter
	@Column(name = "ELEMENT", nullable = false)
	private String element;

	/**
	 * Set only CardTypeEnum values
	 * @see br.com.alreadyhas.cf.model.CardTypeEnum
	 **/
	@Getter
	@Setter
	@Column(name = "CARD_TYPE", nullable = false)
	private Integer type;

	/**
	 * Number of points the card gives. 
	 * It serves both damage and defense. 
	 * This is also when it is withdrawn from the opponent.
	 * @see br.com.alreadyhas.cf.model.CardTypeEnum
	 **/
	@Getter
	@Setter
	@Column(name = "POINTS", nullable = true)
	private Integer points;

	@Getter
	@Setter
	@Column(name = "LEVEL", nullable = true)
	private Integer level;

	@Getter
	@Setter
	@Column(name = "PHOTO", nullable = false)
	private byte[] photo;

	/**
	 * If the card requires a Pet to be activated.
	 * @see br.com.alreadyhas.cf.model.Pet
	 **/
	@Getter
	@Setter
	@Column(name = "REQUIRED_PET", nullable = true)
	private Integer requiredPet;

	/**
	 * If the card requires a other card to be activated.
	 **/
	@Getter
	@Setter
	@Column(name = "REQUIRED_CARD", nullable = true)
	private Integer requiredCard;

	public Card() {/**/}

	public Card(Long id) {
		super(id);
	}

	public Card(String name, String element, Integer type) {
		this.name = name;
		this.element = element;
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}

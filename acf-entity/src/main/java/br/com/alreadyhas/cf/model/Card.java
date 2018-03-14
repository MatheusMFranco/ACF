package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.alreadyhas.cf.contract.Model;
import br.com.alreadyhas.cf.preset.CardTypeEnum;
import br.com.alreadyhas.cf.preset.ElementEnum;
import br.com.alreadyhas.cf.warn.PresetException;
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
 * @see br.com.alreadyhas.cf.preset.CardTypeEnumTest
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
	private String cardName;

	@Getter
	@Setter
	@Column(name = "CARD_DESCRIPTION", nullable = false)
	private String cardDescription;

	/**
	 * @see br.com.alreadyhas.cf.preset.ElementEnum
	 **/
	@Getter
	@Column(name = "ELEMENT", nullable = false)
	private Integer cardElement;

	/**
	 * @see br.com.alreadyhas.cf.preset.CardTypeEnumTest
	 **/
	@Getter
	@Column(name = "CARD_TYPE", nullable = false)
	private Integer type;

	/**
	 * Number of points the card gives. 
	 * It serves both damage and defense. 
	 * This is also when it is withdrawn from the opponent.
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

	public Card(String name, Integer element, Integer type) {
		this.cardName = name;
		this.cardElement = element;
		this.type = type;
	}

	public void setType(Integer type){
		try {
			this.type = CardTypeEnum.fromId(type).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Type", type);
		}
	}

	public void setElement(Integer element){
		try {
			this.cardElement = ElementEnum.fromId(element).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Element", element);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cardElement == null) ? 0 : cardElement.hashCode());
		result = prime * result + ((cardName == null) ? 0 : cardName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		if (cardElement == null) {
			if (other.cardElement != null) {
				return false;
			}
		} else if (!cardElement.equals(other.cardElement)) {
			return false;
		}
		if (cardName == null) {
			if (other.cardName != null) {
				return false;
			}
		} else if (!cardName.equals(other.cardName)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

}

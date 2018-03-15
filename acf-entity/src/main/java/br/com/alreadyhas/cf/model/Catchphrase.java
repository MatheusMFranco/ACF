package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.alreadyhas.cf.model.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Catchphrase</h2>
 * <hr />
 * <p>This class represents the catchphrase that will be said by the characters.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.Character
 */
@Entity
public class Catchphrase extends Model {

	private static final long serialVersionUID = -78782444672333374L;

	@Getter
	@Setter
	@Column(name = "PHRASE", nullable = false)
	private String phrase;

	/**
	 * @see br.com.alreadyhas.cf.model.Character
	 **/
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "CATCHPHRASE_CHARACTER", nullable = false)
	private Character character;

	public Catchphrase() {/**/}

	public Catchphrase(Long id) {
		super(id);
	}

	public Catchphrase(String phrase, Character character) {
		this.phrase = phrase;
		this.character = character;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((phrase == null) ? 0 : phrase.hashCode());
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
		Catchphrase other = (Catchphrase) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (phrase == null) {
			if (other.phrase != null)
				return false;
		} else if (!phrase.equals(other.phrase))
			return false;
		return true;
	}

}

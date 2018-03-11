package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.alreadyhas.cf.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Skin</h2>
 * <hr />
 * <p>This class represents the character's skin.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.Character
 *
 */
@Entity
public class Skin extends Model {

	private static final long serialVersionUID = 6857729531361975491L;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "SKIN_CHARACTER", nullable = false)
	private Character character;

	@Getter
	@Setter
	@Column(name = "PHOTO", nullable = false)
	private byte[] photo;

	@Getter
	@Setter
	@Column(name = "SKIN_NAME", nullable = false)
	private String name;

	@Getter
	@Setter
	@Column(name = "SKIN_DESCRIPTION", nullable = false)
	private String description;

	public Skin() {/**/}

	public Skin(Long id) {
		super(id);
	}

	public Skin(Character character, String name) {
		this.character = character;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Skin other = (Skin) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import br.com.alreadyhas.cf.model.contract.Model;
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
 * @see br.com.alreadyhas.cf.model.Persona
 *
 */
@Entity
@TableGenerator(name = "SKIN")
public class Skin extends Model {

	private static final long serialVersionUID = 6857729531361975491L;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "SKIN_CHARACTER", nullable = false)
	private Persona skinCharacter;

	@Getter
	@Setter
	@Column(name = "PHOTO", nullable = false)
	private byte[] skinPhoto;

	@Getter
	@Setter
	@Column(name = "SKIN_NAME", nullable = false)
	private String skinName;

	@Getter
	@Setter
	@Column(name = "SKIN_DESCRIPTION", nullable = false)
	private String skinDescription;

	public Skin() {/**/}

	public Skin(Long id) {
		super(id);
	}

	public Skin(Persona character, String name) {
		this.skinCharacter = character;
		this.skinName = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((skinCharacter == null) ? 0 : skinCharacter.hashCode());
		result = prime * result + ((skinName == null) ? 0 : skinName.hashCode());
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
		if (skinCharacter == null) {
			if (other.skinCharacter != null)
				return false;
		} else if (!skinCharacter.equals(other.skinCharacter))
			return false;
		if (skinName == null) {
			if (other.skinName != null)
				return false;
		} else if (!skinName.equals(other.skinName))
			return false;
		return true;
	}

}

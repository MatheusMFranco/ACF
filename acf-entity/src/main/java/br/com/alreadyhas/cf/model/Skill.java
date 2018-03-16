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
 * <h2>Skill</h2>
 * <hr />
 * <p>This class represents the character's skill.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.Persona
 *
 */
@Entity
@TableGenerator(name = "SKILL")
public class Skill extends Model {

	private static final long serialVersionUID = 8608826214878309682L;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "SKILL_CHARACTER", nullable = false)
	private Persona character;

	@Getter
	@Setter
	@Column(name = "SKILL_NAME", nullable = false)
	private String skillName;

	@Getter
	@Setter
	@Column(name = "SKILL_DESCRIPTION", nullable = false)
	private String skillDescription;

	@Getter
	@Setter
	@Column(name = "PHOTO", nullable = false)
	private byte[] skillPhoto;

	@Getter
	@Setter
	@Column(name = "POINTS", nullable = false)
	private Integer points;

	public Skill() {/**/}

	public Skill(Long id) {
		super(id);
	}

	public Skill(Persona character, String name) {
		this.character = character;
		this.skillName = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
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
		Skill other = (Skill) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}

}

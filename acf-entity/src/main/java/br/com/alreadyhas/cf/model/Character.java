package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.alreadyhas.cf.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Character</h2>
 * <hr />
 * <p>This class represents the character that the player in the direction of the system in the match.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.preset.GenderEnum
 * @see br.com.alreadyhas.cf.preset.SpecieEnum
 * @see br.com.alreadyhas.cf.preset.FactionEnum
 *
 */
@Entity
public class Character extends Model {

	private static final long serialVersionUID = -7953605102474222091L;

	@Getter
	@Setter
	@Column(name = "CHARACTER_NAME", nullable = false)
	private String name;

	@Getter
	@Setter
	@Column(name = "CHARACTER_DESCRIPTION", nullable = false)
	private String description;

	@Getter
	@Setter
	@Column(name = "ALTER_EGO", nullable = true)
	private String alterEgo;

	/**
	 * @see br.com.alreadyhas.cf.preset.GenderEnum
	 **/
	@Getter
	@Setter
	@Column(name = "GENDER", nullable = false)
	private Integer gender;

	/**
	 * @see br.com.alreadyhas.cf.model.SpecieEnum
	 **/
	@Getter
	@Setter
	@Column(name = "SPECIE", nullable = false)
	private Integer specie;

	/**
	 * @see br.com.alreadyhas.cf.model.FactionEnum
	 **/
	@Getter
	@Setter
	@Column(name = "FACTION", nullable = false)
	private Integer faction;

	public Character() {/**/}

	public Character(Long id) {
		super(id);
	}

	public Character(String name, Integer faction) {
		this.name = name;
		this.faction = faction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faction == null) ? 0 : faction.hashCode());
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
		Character other = (Character) obj;
		if (faction == null) {
			if (other.faction != null)
				return false;
		} else if (!faction.equals(other.faction))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

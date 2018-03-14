package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.alreadyhas.cf.contract.Model;
import br.com.alreadyhas.cf.preset.FactionEnum;
import br.com.alreadyhas.cf.preset.GenderEnum;
import br.com.alreadyhas.cf.preset.SpecieEnum;
import br.com.alreadyhas.cf.warn.PresetException;
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
	@Column(name = "GENDER", nullable = false)
	private Integer gender;

	/**
	 * @see br.com.alreadyhas.cf.model.SpecieEnum
	 **/
	@Getter
	@Column(name = "SPECIE", nullable = false)
	private Integer specie;

	/**
	 * @see br.com.alreadyhas.cf.model.FactionEnum
	 **/
	@Getter
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

	public void setGender(Integer gender){
		try {
			this.gender = GenderEnum.fromId(gender).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Gender", gender);
		}
	}

	public void setSpecie(Integer specie){
		try {
			this.specie = SpecieEnum.fromId(specie).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Specie", specie);
		}
	}

	public void setFaction(Integer faction){
		try {
			this.faction = FactionEnum.fromId(faction).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Faction", faction);
		}
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

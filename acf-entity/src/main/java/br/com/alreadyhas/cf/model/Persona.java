package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.TableGenerator;

import br.com.alreadyhas.cf.model.contract.Model;
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
@Entity(name="persona")
@TableGenerator(name = "PERSONA")
public class Persona extends Model {

	private static final long serialVersionUID = -7953605102474222091L;

	@Getter
	@Setter
	@Column(name = "CHARACTER_NAME", nullable = false)
	private String characterName;

	@Getter
	@Setter
	@Column(name = "CHARACTER_DESCRIPTION", nullable = false)
	private String characterDescription;

	@Getter
	@Setter
	@Column(name = "ALTER_EGO", nullable = true)
	private String alterEgo;

	/**
	 * @see br.com.alreadyhas.cf.preset.GenderEnum
	 **/
	@Getter
	@Column(name = "GENDER", nullable = false)
	private Integer characterGender;

	/**
	 * @see br.com.alreadyhas.cf.preset.SpecieEnum
	 **/
	@Getter
	@Column(name = "SPECIE", nullable = false)
	private Integer characterSpecie;

	/**
	 * @see br.com.alreadyhas.cf.preset.FactionEnum
	 **/
	@Getter
	@Column(name = "FACTION", nullable = false)
	private Integer characterFaction;

	public Persona() {/**/}

	public Persona(Long id) {
		super(id);
	}

	public Persona(String name, Integer faction) {
		this.characterName = name;
		this.characterFaction = faction;
	}

	public void setCharacterGender(Integer gender){
		try {
			this.characterGender = GenderEnum.fromId(gender).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Gender", gender);
		}
	}

	public void setCharacterSpecie(Integer specie){
		try {
			this.characterSpecie = SpecieEnum.fromId(specie).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Specie", specie);
		}
	}

	public void setCharacterFaction(Integer faction){
		try {
			this.characterFaction = FactionEnum.fromId(faction).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Faction", faction);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((characterFaction == null) ? 0 : characterFaction.hashCode());
		result = prime * result + ((characterName == null) ? 0 : characterName.hashCode());
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
		Persona other = (Persona) obj;
		if (characterFaction == null) {
			if (other.characterFaction != null)
				return false;
		} else if (!characterFaction.equals(other.characterFaction))
			return false;
		if (characterName == null) {
			if (other.characterName != null)
				return false;
		} else if (!characterName.equals(other.characterName))
			return false;
		return true;
	}

}

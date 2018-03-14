package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.alreadyhas.cf.contract.Model;
import br.com.alreadyhas.cf.preset.FactionEnum;
import br.com.alreadyhas.cf.preset.GenderEnum;
import br.com.alreadyhas.cf.preset.PetTypeEnum;
import br.com.alreadyhas.cf.preset.SpecieEnum;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Pet</h2>
 * <hr />
 * <p>This class represents the pet card.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.preset.PetTypeEnum
 * @see br.com.alreadyhas.cf.preset.ElementEnum
 * @see br.com.alreadyhas.cf.preset.FactionEnum
 * @see br.com.alreadyhas.cf.preset.SpecieEnum
 *
 */
@Entity
public class Pet extends Model {

	private static final long serialVersionUID = -720661375713506377L;

	@Getter
	@Setter
	@Column(name = "PET_NAME", nullable = false)
	private String name;

	@Getter
	@Setter
	@Column(name = "PET_DESCRIPTION", nullable = false)
	private String description;

	/**
	 * @see br.com.alreadyhas.cf.preset.PetTypeEnum
	 **/
	@Getter
	@Column(name = "PET_TYPE", nullable = false)
	private Integer type;

	@Getter
	@Setter
	@Column(name = "EFFECT")
	private String effect;

	@Getter
	@Setter
	@Column(name = "LEVEL", nullable = false)
	private Integer level;

	@Getter
	@Setter
	@Column(name = "ATTACK", nullable = false)
	private Integer attack;

	@Getter
	@Setter
	@Column(name = "LIFE", nullable = false)
	private Integer life;

	/**
	 * @see br.com.alreadyhas.cf.preset.ElementEnum
	 **/
	@Getter
	@Column(name = "ELEMENT", nullable = false)
	private Integer element;

	/**
	 * @see br.com.alreadyhas.cf.preset.FactionEnum
	 **/
	@Getter
	@Column(name = "FACTION", nullable = false)
	private Integer faction;

	/**
	 * @see br.com.alreadyhas.cf.preset.SpecieEnum
	 **/
	@Getter
	@Column(name = "SPECIE", nullable = false)
	private Integer specie;

	@Getter
	@Setter
	@Column(name = "PHOTO", nullable = false)
	private byte[] photo;

	public Pet() {/**/}

	public Pet(Long id) {
		super(id);
	}

	public Pet(String name, Integer type, Integer element) {
		this.name = name;
		this.type = type;
		this.element = element;
	}

	public void setType(Integer type){
		try {
			this.type = PetTypeEnum.fromId(type).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Type", type);
		}
	}

	public void setElement(Integer element){
		try {
			this.element = GenderEnum.fromId(element).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Element", element);
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
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Pet other = (Pet) obj;
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

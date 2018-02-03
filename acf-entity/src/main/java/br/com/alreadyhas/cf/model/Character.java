package br.com.alreadyhas.cf.model;

import javax.persistence.Entity;

import br.com.alreadyhas.cf.contract.Model;

/**
 * <h2>Character</h2>
 * <hr />
 * <p>Essa classe representa o personagem que o jogador irá escolher na partida.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category POJO
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.GenderEnum
 * @see br.com.alreadyhas.cf.model.Specie
 * @see br.com.alreadyhas.cf.model.Faction
 *
 */
@Entity
public class Character extends Model {

	private static final long serialVersionUID = 3973282144614413118L;

	private String name;

	private String description;

	private String alterEgo;

	/**
	 * @see br.com.alreadyhas.cf.model.GenderEnum
	 **/
	private Integer gender;

	private Integer specie;

	private Integer faction;

	public Character() {/**/}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAlterEgo() {
		return alterEgo;
	}

	public void setAlterEgo(String alterEgo) {
		this.alterEgo = alterEgo;
	}

	/**
	 * Get a GenderEnum value.
	 * @see br.com.alreadyhas.cf.model.GenderEnum
	 **/
	public Integer getGender() {
		return gender;
	}

	/**
	 * Set only GenderEnum values.
	 * @see br.com.alreadyhas.cf.model.GenderEnum
	 **/
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getSpecie() {
		return specie;
	}

	public void setSpecie(Integer specie) {
		this.specie = specie;
	}

	public Integer getFaction() {
		return faction;
	}

	public void setFaction(Integer faction) {
		this.faction = faction;
	}
}

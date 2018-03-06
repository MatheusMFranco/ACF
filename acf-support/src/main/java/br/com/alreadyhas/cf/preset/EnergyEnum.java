package br.com.alreadyhas.cf.preset;

import lombok.Getter;

/**
 * <h2>EnergyEnum</h2>
 * <hr />
 * <p>This class shows the energies used in the game to activate combat skills.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum EnergyEnum {

	BIRL    ("It is used for skills that need to use the physical strength of the character."), 
	DESU    ("This ability is used for skills that need to use the mind."),
	DELICIA ("Used for magical abilities, they do not need to have brute or mental strength."),
	ZOEIRA  ("Serves for any type of skill."); 

	@Getter
	private String description;

	private EnergyEnum(String description) {
		this.description = description;
	}

}

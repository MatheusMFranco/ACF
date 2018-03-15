package br.com.alreadyhas.cf.preset;

import br.com.alreadyhas.cf.preset.contract.Preset;
import br.com.alreadyhas.cf.warn.PresetException;
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
public enum EnergyEnum implements Preset {

	BIRL    (1, "It is used for skills that need to use the physical strength of the character."), 
	DESU    (2, "This ability is used for skills that need to use the mind."),
	DELICIA (3, "Used for magical abilities, they do not need to have brute or mental strength."),
	ZOEIRA  (4, "Serves for any type of skill."); 

	@Getter
	private Integer code;

	@Getter
	private String description;

	private EnergyEnum(Integer code, String description) {
		this.code        = code;
		this.description = description;
	}

	public static EnergyEnum fromId(Integer id) throws PresetException {
		for (EnergyEnum energyEnum : EnergyEnum.values()) {
			if (energyEnum.getCode().equals(id)) {
				return energyEnum;
			}
		}
		throw new PresetException(EnergyEnum.class, id);
	}

}

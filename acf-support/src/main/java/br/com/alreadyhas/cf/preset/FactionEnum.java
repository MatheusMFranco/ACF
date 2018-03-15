package br.com.alreadyhas.cf.preset;

import br.com.alreadyhas.cf.preset.contract.Preset;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;

/**
 * <h2>FactionEnum</h2>
 * <hr />
 * <p>This class shows the factions.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum FactionEnum implements Preset {

	 COSMIC      (1),
	 FANTASTIC   (2);

	@Getter
	private Integer code;

	private FactionEnum(Integer code) {
		this.code = code;
	}

	public static FactionEnum fromId(Integer id) throws PresetException {
		for (FactionEnum factionEnum : FactionEnum.values()) {
			if (factionEnum.getCode().equals(id)) {
				return factionEnum;
			}
		}
		throw new PresetException(SpecieEnum.class, id);
	}

}

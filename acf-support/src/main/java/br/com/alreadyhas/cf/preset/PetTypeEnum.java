package br.com.alreadyhas.cf.preset;

import br.com.alreadyhas.cf.constract.Preset;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;

/**
 * <h2>PetTypeEnum</h2>
 * <hr />
 * <p>This class shows the pet types.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum PetTypeEnum implements Preset {

	 NORMAL     (1),
	 EFFECT     (2),
	 RITUAL     (3),
	 FUSION     (4),
	 HYBRID     (5),
	 EVOLUTION  (6),
	 LEVEL      (7);

	@Getter
	private Integer code;

	private PetTypeEnum(Integer code) {
		this.code = code;
	}

	public static PetTypeEnum fromId(Integer id) throws PresetException {
		for (PetTypeEnum petType : PetTypeEnum.values()) {
			if (petType.getCode().equals(id)) {
				return petType;
			}
		}
		throw new PresetException(SpecieEnum.class, id);
	}

}

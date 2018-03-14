package br.com.alreadyhas.cf.preset;

import br.com.alreadyhas.cf.constract.Preset;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;

/**
 * <h2>SpecieEnum</h2>
 * <hr />
 * <p>This class shows the species.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum SpecieEnum implements Preset{

	 HUMAN     (1),
	 BEAR      (2),
	 DEMON     (3),
	 SCARECROW (4),
	 SPIRIT    (5),
	 DOG       (6),
	 ELF       (7),
	 CAT       (8),
	 FAIRY     (9);

	@Getter
	private Integer code;

	private SpecieEnum(Integer code) {
		this.code = code;
	}

	public static SpecieEnum fromId(Integer id) throws PresetException {
		for (SpecieEnum specie : SpecieEnum.values()) {
			if (specie.getCode().equals(id)) {
				return specie;
			}
		}
		throw new PresetException(SpecieEnum.class, id);
	}

}

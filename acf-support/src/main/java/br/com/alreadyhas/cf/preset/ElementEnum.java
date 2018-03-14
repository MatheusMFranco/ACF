package br.com.alreadyhas.cf.preset;

import br.com.alreadyhas.cf.constract.Preset;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;

/**
 * <h2>ElementEnum</h2>
 * <hr />
 * <p>This class shows the elements.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum ElementEnum implements Preset {

	 FIRE      (1),
	 WATER     (2),
	 EARTH     (3),
	 AIR       (4),
	 HEART     (5),
	 DARKNESS  (6),
	 LIGHT     (7);

	@Getter
	private Integer code;

	private ElementEnum(Integer code) {
		this.code = code;
	}

	public static ElementEnum fromId(Integer id) throws PresetException {
		for (ElementEnum elementEnum : ElementEnum.values()) {
			if (elementEnum.getCode().equals(id)) {
				return elementEnum;
			}
		}
		throw new PresetException(ElementEnum.class, id);
	}

}

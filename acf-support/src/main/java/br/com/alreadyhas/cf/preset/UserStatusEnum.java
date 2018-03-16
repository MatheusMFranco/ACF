package br.com.alreadyhas.cf.preset;

import br.com.alreadyhas.cf.preset.contract.Preset;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;

/**
 * <h2>UserStatusEnum</h2>
 * <hr />
 * <p>This class shows the user's situation.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum UserStatusEnum implements Preset{

	 NEW     (1),
	 ACTIVE  (2),
	 BANNED  (3);

	@Getter
	private Integer code;

	private UserStatusEnum(Integer code) {
		this.code = code;
	}

	public static UserStatusEnum fromId(Integer id) throws PresetException {
		for (UserStatusEnum situation : UserStatusEnum.values()) {
			if (situation.getCode().equals(id)) {
				return situation;
			}
		}
		throw new PresetException(UserStatusEnum.class, id);
	}

}

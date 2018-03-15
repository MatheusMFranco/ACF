package br.com.alreadyhas.cf.preset;

import br.com.alreadyhas.cf.preset.contract.Preset;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;

/**
 * <h2>GenderEnum</h2>
 * <hr />
 * <p>This class represents the character's gender.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum GenderEnum implements Preset {

	MALE                  (1,  "M"  , "Male"),
	FEMALE                (2,  "F"  , "Female"),
	DO_NOT_KNOW           (3,  "?"  , "Do not know..."),
	BOY_AND_GIRL          (4,  "H"  , "Boy and Girl"),
	NONE                  (5,  "N"  , "None"),
	ALIEN                 (6,  "A"  , "Alien"),
	WHATEVER              (7,  "W"  , "Whatever"),
	I_WAS_A_BOY           (8,  "TM" , "I was a boy"),
	I_WAS_A_GIRL          (9,  "TF" , "I was a girl"),
	I_WAS_ALREADY_TWO     (10, "B"  , "I was already two"),
	I_WAS_ALREAY_ALIEN    (11, "TA" , "I was already alien"),
	I_JUST_WANT_TO_PLAY   (12, "'-'", "I just want to play"),
	GHOST                 (13, "G"  , "Ghost"),
	FELIPE                (14, "-q" , "Felipe"),
	OTHER                 (15, "O"  , "Other"),
	ID_RATHER_NOT_WITNESS (16, ""   , "I'd rather not witness"),
	ALL                   (17, "ALL", "All");

	@Getter
	private Integer code;

	@Getter
	private String symbol;

	@Getter
	private String description;

	private GenderEnum(Integer code, String symbol, String description) {
		this.code = code;
		this.symbol = symbol;
		this.description = description;
	}

	public static GenderEnum fromId(Integer id) throws PresetException {
		for (GenderEnum genderEnum : GenderEnum.values()) {
			if (genderEnum.getCode().equals(id)) {
				return genderEnum;
			}
		}
		throw new PresetException(SpecieEnum.class, id);
	}
}

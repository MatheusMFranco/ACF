package br.com.alreadyhas.cf.preset;

/**
 * <h2>GenderEnum</h2>
 * <hr />
 * <p>Essa classe representa o personagem que o jogador irá escolher na partida.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum GenderEnum {

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

	private Integer code;
	private String symbol;
	private String description;

	private GenderEnum(Integer code, String symbol, String description) {
		this.code = code;
		this.symbol = symbol;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getSymbol() {
		return symbol;
	}

}

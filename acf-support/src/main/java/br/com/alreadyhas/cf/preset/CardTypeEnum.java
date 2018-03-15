package br.com.alreadyhas.cf.preset;

import br.com.alreadyhas.cf.preset.contract.Preset;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;

/**
 * <h2>CardTypeEnum</h2>
 * <hr />
 * <p>This class shows the card types.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Preset
 * @version 0.1
 *
 */
public enum CardTypeEnum implements Preset{

	 MAGIC      (1, "Can give magic abilities to the hero or pet."),
	 TRAP       (2, "Can be used to defend or counterattack an enemy attack."),
	 BACKGROUND (3, "Changes the battlefield environment."),
	 EQUIPMENT  (4, "Can equip a hero or a pet."),
	 RITUAL     (5, "Serves to summon specific pets."), 
	 CONTINUOUS (6, "Continues for several turns until it is destroyed."), 
	 TOKEN      (7, "This card can be used to perform some pet effect that needs collection.");

	@Getter
	private Integer code;

	@Getter
	private String description;

	private CardTypeEnum(Integer code, String description) {
		this.code        = code;
		this.description = description;
	}

	public static CardTypeEnum fromId(Integer id) throws PresetException {
		for (CardTypeEnum card : CardTypeEnum.values()) {
			if (card.getCode().equals(id)) {
				return card;
			}
		}
		throw new PresetException(CardTypeEnum.class, id);
	}
}


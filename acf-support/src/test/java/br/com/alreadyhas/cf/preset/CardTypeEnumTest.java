package br.com.alreadyhas.cf.preset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alreadyhas.cf.base.EnumTest;
import br.com.alreadyhas.cf.warn.PresetException;


public class CardTypeEnumTest extends EnumTest{

	private static final Integer[] EXPECTEDS = {1, 2, 3, 4, 5, 6, 7};

	@Test
	public void verifyException(){
		try {
			CardTypeEnum.fromId(-1);
			CardTypeEnum.fromId(0);
			CardTypeEnum.fromId(99);
			CardTypeEnum.fromId(999);
			CardTypeEnum.fromId(CardTypeEnum.values().length + 1);
		} catch (PresetException e) {}
	}

	@Test
	public void verifyEnumerationCode(){

		Integer[] expecteds = EXPECTEDS;
		List<Integer> actuals = new ArrayList<Integer>();

		for(CardTypeEnum card : CardTypeEnum.values()){
			actuals.add(card.getCode());
		}

		assertPreset(expecteds, actuals);
	}

	@Test
	public void verifyEnumeration(){

		Integer[] codes = EXPECTEDS;
		List<CardTypeEnum> actuals = new ArrayList<CardTypeEnum>();

		for(int i = 0; i < EXPECTEDS.length; i++){
			try {
				actuals.add(CardTypeEnum.fromId(codes[i]));
			} catch (PresetException e) {
				fail("veridyEnumeration() failed");
			}
		}

		assertArrayEquals(CardTypeEnum.values(), actuals.toArray());
		Assert.assertTrue(codes.length == CardTypeEnum.values().length);
	}
}

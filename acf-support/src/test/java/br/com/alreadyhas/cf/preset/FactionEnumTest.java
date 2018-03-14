package br.com.alreadyhas.cf.preset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alreadyhas.cf.base.EnumTest;
import br.com.alreadyhas.cf.warn.PresetException;


public class FactionEnumTest extends EnumTest{

	private static final Integer[] EXPECTEDS = {1, 2};

	@Test
	public void verifyException(){
		try {
			FactionEnum.fromId(-1);
			FactionEnum.fromId(0);
			FactionEnum.fromId(99);
			FactionEnum.fromId(999);
			FactionEnum.fromId(FactionEnum.values().length + 1);
		} catch (PresetException e) {}
	}

	@Test
	public void verifyEnumerationCode(){

		Integer[] expecteds = EXPECTEDS;
		List<Integer> actuals = new ArrayList<Integer>();

		for(FactionEnum card : FactionEnum.values()){
			actuals.add(card.getCode());
		}

		assertPreset(expecteds, actuals);
	}

	@Test
	public void verifyEnumeration(){

		Integer[] codes = EXPECTEDS;
		List<FactionEnum> actuals = new ArrayList<FactionEnum>();

		for(int i = 0; i < EXPECTEDS.length; i++){
			try {
				actuals.add(FactionEnum.fromId(codes[i]));
			} catch (PresetException e) {
				fail("veridyEnumeration() failed");
			}
		}

		assertArrayEquals(FactionEnum.values(), actuals.toArray());
		Assert.assertTrue(codes.length == FactionEnum.values().length);
	}
}

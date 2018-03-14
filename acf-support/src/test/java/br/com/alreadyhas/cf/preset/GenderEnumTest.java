package br.com.alreadyhas.cf.preset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alreadyhas.cf.base.EnumTest;
import br.com.alreadyhas.cf.warn.PresetException;


public class GenderEnumTest extends EnumTest{

	private static final Integer[] EXPECTEDS = {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17
			};

	@Test
	public void verifyException(){
		try {
			GenderEnum.fromId(-1);
			GenderEnum.fromId(0);
			GenderEnum.fromId(99);
			GenderEnum.fromId(999);
			GenderEnum.fromId(GenderEnum.values().length + 1);
		} catch (PresetException e) {}
	}

	@Test
	public void verifyEnumerationCode(){

		Integer[] expecteds = EXPECTEDS;
		List<Integer> actuals = new ArrayList<Integer>();

		for(GenderEnum card : GenderEnum.values()){
			actuals.add(card.getCode());
		}

		assertPreset(expecteds, actuals);
	}

	@Test
	public void verifyEnumeration(){

		Integer[] codes = EXPECTEDS;
		List<GenderEnum> actuals = new ArrayList<GenderEnum>();

		for(int i = 0; i < EXPECTEDS.length; i++){
			try {
				actuals.add(GenderEnum.fromId(codes[i]));
			} catch (PresetException e) {
				fail("veridyEnumeration() failed");
			}
		}

		assertArrayEquals(GenderEnum.values(), actuals.toArray());
		Assert.assertTrue(codes.length == GenderEnum.values().length);
	}
}

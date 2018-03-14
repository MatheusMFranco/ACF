package br.com.alreadyhas.cf.preset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alreadyhas.cf.base.EnumTest;
import br.com.alreadyhas.cf.warn.PresetException;


public class SpecieEnumTest extends EnumTest{

	private static final Integer[] EXPECTEDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	@Test
	public void verifyException(){
		try {
			SpecieEnum.fromId(-1);
			SpecieEnum.fromId(0);
			SpecieEnum.fromId(99);
			SpecieEnum.fromId(999);
			SpecieEnum.fromId(SpecieEnum.values().length + 1);
		} catch (PresetException e) {}
	}

	@Test
	public void verifyEnumerationCode(){

		Integer[] expecteds = EXPECTEDS;
		List<Integer> actuals = new ArrayList<Integer>();

		for(SpecieEnum card : SpecieEnum.values()){
			actuals.add(card.getCode());
		}

		assertPreset(expecteds, actuals);
	}

	@Test
	public void verifyEnumeration(){

		Integer[] codes = EXPECTEDS;
		List<SpecieEnum> actuals = new ArrayList<SpecieEnum>();

		for(int i = 0; i < EXPECTEDS.length; i++){
			try {
				actuals.add(SpecieEnum.fromId(codes[i]));
			} catch (PresetException e) {
				fail("veridyEnumeration() failed");
			}
		}

		assertArrayEquals(SpecieEnum.values(), actuals.toArray());
		Assert.assertTrue(codes.length == SpecieEnum.values().length);
	}
}

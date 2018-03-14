package br.com.alreadyhas.cf.preset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alreadyhas.cf.base.EnumTest;
import br.com.alreadyhas.cf.warn.PresetException;


public class PetTypeEnumTest extends EnumTest{

	private static final Integer[] EXPECTEDS = {1, 2, 3, 4, 5, 6, 7};

	@Test
	public void verifyException(){
		try {
			PetTypeEnum.fromId(-1);
			PetTypeEnum.fromId(0);
			PetTypeEnum.fromId(99);
			PetTypeEnum.fromId(999);
			PetTypeEnum.fromId(PetTypeEnum.values().length + 1);
		} catch (PresetException e) {}
	}

	@Test
	public void verifyEnumerationCode(){

		Integer[] expecteds = EXPECTEDS;
		List<Integer> actuals = new ArrayList<Integer>();

		for(PetTypeEnum card : PetTypeEnum.values()){
			actuals.add(card.getCode());
		}

		assertPreset(expecteds, actuals);
	}

	@Test
	public void verifyEnumeration(){

		Integer[] codes = EXPECTEDS;
		List<PetTypeEnum> actuals = new ArrayList<PetTypeEnum>();

		for(int i = 0; i < EXPECTEDS.length; i++){
			try {
				actuals.add(PetTypeEnum.fromId(codes[i]));
			} catch (PresetException e) {
				fail("veridyEnumeration() failed");
			}
		}

		assertArrayEquals(PetTypeEnum.values(), actuals.toArray());
		Assert.assertTrue(codes.length == PetTypeEnum.values().length);
	}
}

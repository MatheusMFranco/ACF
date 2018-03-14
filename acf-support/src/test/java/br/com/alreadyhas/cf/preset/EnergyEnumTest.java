package br.com.alreadyhas.cf.preset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alreadyhas.cf.base.EnumTest;
import br.com.alreadyhas.cf.warn.PresetException;


public class EnergyEnumTest extends EnumTest{

	private static final Integer[] EXPECTEDS = {1, 2, 3, 4};

	@Test
	public void verifyException(){
		try {
			EnergyEnum.fromId(-1);
			EnergyEnum.fromId(0);
			EnergyEnum.fromId(99);
			EnergyEnum.fromId(999);
			EnergyEnum.fromId(EnergyEnum.values().length + 1);
		} catch (PresetException e) {}
	}

	@Test
	public void verifyEnumerationCode(){

		Integer[] expecteds = EXPECTEDS;
		List<Integer> actuals = new ArrayList<Integer>();

		for(EnergyEnum card : EnergyEnum.values()){
			actuals.add(card.getCode());
		}

		assertPreset(expecteds, actuals);
	}

	@Test
	public void verifyEnumeration(){

		Integer[] codes = EXPECTEDS;
		List<EnergyEnum> actuals = new ArrayList<EnergyEnum>();

		for(int i = 0; i < EXPECTEDS.length; i++){
			try {
				actuals.add(EnergyEnum.fromId(codes[i]));
			} catch (PresetException e) {
				fail("veridyEnumeration() failed");
			}
		}

		assertArrayEquals(EnergyEnum.values(), actuals.toArray());
		Assert.assertTrue(codes.length == EnergyEnum.values().length);
	}
}

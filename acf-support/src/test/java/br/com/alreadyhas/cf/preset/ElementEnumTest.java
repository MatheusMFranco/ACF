package br.com.alreadyhas.cf.preset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.alreadyhas.cf.base.EnumTest;
import br.com.alreadyhas.cf.warn.PresetException;


public class ElementEnumTest extends EnumTest{

	private static final Integer[] EXPECTEDS = {1, 2, 3, 4, 5, 6, 7};

	@Test
	public void verifyException(){
		try {
			ElementEnum.fromId(-1);
			ElementEnum.fromId(0);
			ElementEnum.fromId(99);
			ElementEnum.fromId(999);
			ElementEnum.fromId(ElementEnum.values().length + 1);
		} catch (PresetException e) {}
	}

	@Test
	public void verifyEnumerationCode(){

		Integer[] expecteds = EXPECTEDS;
		List<Integer> actuals = new ArrayList<Integer>();

		for(ElementEnum element : ElementEnum.values()){
			actuals.add(element.getCode());
		}

		assertPreset(expecteds, actuals);
	}

	@Override
	public void verifyEnumeration() {

		Integer[] codes = EXPECTEDS;
		List<ElementEnum> actuals = new ArrayList<ElementEnum>();

		for(int i = 0; i < EXPECTEDS.length; i++){
			try {
				actuals.add(ElementEnum.fromId(codes[i]));
			} catch (PresetException e) {
				fail("veridyEnumeration() failed");
			}
		}

		assertArrayEquals(ElementEnum.values(), actuals.toArray());
	}

}

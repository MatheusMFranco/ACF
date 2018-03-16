package br.com.alreadyhas.cf.preset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alreadyhas.cf.base.EnumTest;
import br.com.alreadyhas.cf.warn.PresetException;


public class UserStatusEnumTest extends EnumTest{

	private static final Integer[] EXPECTEDS = {1, 2, 3};

	@Test
	public void verifyException(){
		try {
			UserStatusEnum.fromId(-1);
			UserStatusEnum.fromId(0);
			UserStatusEnum.fromId(99);
			UserStatusEnum.fromId(999);
			UserStatusEnum.fromId(UserStatusEnum.values().length + 1);
		} catch (PresetException e) {}
	}

	@Test
	public void verifyEnumerationCode(){

		Integer[] expecteds = EXPECTEDS;
		List<Integer> actuals = new ArrayList<Integer>();

		for(UserStatusEnum card : UserStatusEnum.values()){
			actuals.add(card.getCode());
		}

		assertPreset(expecteds, actuals);
	}

	@Test
	public void verifyEnumeration(){

		Integer[] codes = EXPECTEDS;
		List<UserStatusEnum> actuals = new ArrayList<UserStatusEnum>();

		for(int i = 0; i < EXPECTEDS.length; i++){
			try {
				actuals.add(UserStatusEnum.fromId(codes[i]));
			} catch (PresetException e) {
				fail("veridyEnumeration() failed");
			}
		}

		assertArrayEquals(UserStatusEnum.values(), actuals.toArray());
		Assert.assertTrue(codes.length == UserStatusEnum.values().length);
	}
}

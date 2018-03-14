package br.com.alreadyhas.cf.base;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

/**
 * <h2>EnumTest</h2>
 * <hr />
 * <p>Class made to facilitate the creation of enum tests .</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Util
 * @version 0.1
 *
 */
public abstract class EnumTest {

	public abstract void verifyException();
	public abstract void verifyEnumerationCode();
	public abstract void verifyEnumeration();

	public void assertPreset(Integer[] expecteds, List<Integer> actuals) {
		Arrays.sort(actuals.toArray());
		assertArrayEquals(expecteds, actuals.toArray());
		Assert.assertTrue(expecteds.length == actuals.size());
	}

}

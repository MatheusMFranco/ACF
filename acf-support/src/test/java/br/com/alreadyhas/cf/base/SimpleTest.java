package br.com.alreadyhas.cf.base;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

/**
 * <h2>SimpleTest</h2>
 * <hr />
 * <p>Class made to facilitate the creation of tests.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Util
 * @version 0.1
 *
 */
public abstract class SimpleTest {

	public void equalsToArray(List<?> expecteds, List<?>actuals){
		assertArrayEquals(expecteds.toArray(), actuals.toArray());
	}

}

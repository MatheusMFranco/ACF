package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class AchievementTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Achievement odd = new Achievement();
		Achievement even = new Achievement();
		test.verifyTrue(odd, even);

		//Test #2: All values by constructor
		byte[] photoOdd = {1, 2, 3};
		byte[] photoEven = {1, 2, 3};
		odd = new Achievement("A", "B", photoOdd);
		even = new Achievement("A", "B", photoEven);
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Achievement(1L), new Achievement(1L));

		//Test #5: All values by set
		test.verifyTrue(build(photoOdd), build(photoEven));

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #6: Id by constructor
		test.verifyFalse(new Achievement(1L), new Achievement(2L));

		//Test #7: All values by constructor
		byte[] photoOdd =  {5, 6, 7};
		byte[] photoEven = {1, 2, 3};
		Achievement odd = new Achievement("A", "B", photoOdd);
		Achievement even = new Achievement("B", "A", photoEven);
		test.verifyFalse(odd, even);

		//Test #8: Name
		odd = new Achievement();
		odd.setName("A");
		even = new Achievement();
		even.setName("B");
		test.verifyFalse(odd, even);

		//Test #9: Description
		odd = new Achievement();
		odd.setDescription("A");
		even = new Achievement();
		even.setDescription("B");
		test.verifyFalse(odd, even);

		//Test #10: Photo
		photoOdd[1] = 9;
		photoEven[1] = 10;
		odd = new Achievement();
		odd.setPhoto(photoOdd);
		even = new Achievement();
		even.setPhoto(photoEven);
		test.verifyFalse(odd, even);

	}

	private Achievement build(byte[] photo1) {
		Achievement achievement = new Achievement();
		achievement.setId(1L);
		achievement.setDescription("A");
		achievement.setName("B");
		achievement.setPhoto(photo1);
		return achievement;
	}

}

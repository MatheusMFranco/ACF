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
		odd = new Achievement("A", "B");
		even = new Achievement("A", "B");
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Achievement(1L), new Achievement(1L));

		//Test #5: All values by set
		test.verifyTrue(build(), build());

		//Test #6: Photo
		byte[] photoOdd = {9};
		byte[] photoEven = {10};
		odd = new Achievement();
		odd.setAchievementPhoto(photoOdd);
		even = new Achievement();
		even.setAchievementPhoto(photoEven);
		test.verifyTrue(odd, even);
	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #7: Id by constructor
		test.verifyFalse(new Achievement(1L), new Achievement(2L));

		//Test #8: All values by constructor
		Achievement odd = new Achievement("A", "B");
		Achievement even = new Achievement("B", "A");
		test.verifyFalse(odd, even);

		//Test #9: Name
		odd = new Achievement();
		odd.setAchievementName("A");
		even = new Achievement();
		even.setAchievementName("B");
		test.verifyFalse(odd, even);

		//Test #10: Description
		odd = new Achievement();
		odd.setAchievementDescription("A");
		even = new Achievement();
		even.setAchievementDescription("B");
		test.verifyFalse(odd, even);

	}

	private Achievement build() {
		Achievement achievement = new Achievement();
		achievement.setId(1L);
		achievement.setAchievementDescription("A");
		achievement.setAchievementName("B");
		return achievement;
	}

}

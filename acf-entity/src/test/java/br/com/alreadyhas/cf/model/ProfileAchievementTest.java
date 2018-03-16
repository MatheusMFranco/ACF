package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class ProfileAchievementTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		ProfileAchievement odd = new ProfileAchievement();
		ProfileAchievement even = new ProfileAchievement();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new ProfileAchievement(new ProfileChampion(1L), new Achievement(1L));
		even = new ProfileAchievement(new ProfileChampion(1L), new Achievement(1L));
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new ProfileAchievement(1L), new ProfileAchievement(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #6: Id by constructor
		test.verifyFalse(new ProfileAchievement(1L), new ProfileAchievement(2L));

		//Test #7: All required values by constructor
		ProfileAchievement odd = new ProfileAchievement(new ProfileChampion(1L), new Achievement(1L));
		ProfileAchievement even = new ProfileAchievement(new ProfileChampion(2L), new Achievement(2L));
		test.verifyFalse(odd, even);

		//Test #8: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #9: User Value
		odd = new ProfileAchievement();
		odd.setUserProfile(new ProfileChampion(1L));
		even = new ProfileAchievement();
		even.setUserProfile(new ProfileChampion(2L));
		test.verifyFalse(odd, even);

		//Test #10: Achievement Value
		odd = new ProfileAchievement();
		odd.setAchievement(new Achievement(1L));
		even = new ProfileAchievement();
		even.setAchievement(new Achievement(2L));
		test.verifyFalse(odd, even);

	}

	private ProfileAchievement build() {
		ProfileAchievement profileAchievement = new ProfileAchievement();
		profileAchievement.setId(1L);
		profileAchievement.setUserProfile(new ProfileChampion(1L));
		profileAchievement.setAchievement(new Achievement(1L));
		return profileAchievement;
	}

}

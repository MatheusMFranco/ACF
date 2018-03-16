package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class ProfileSkillTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		ProfileSkill odd = new ProfileSkill();
		ProfileSkill even = new ProfileSkill();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new ProfileSkill(new ProfileChampion(1L), new Skill(1L));
		even = new ProfileSkill(new ProfileChampion(1L), new Skill(1L));
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new ProfileSkill(1L), new ProfileSkill(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #6: Id by constructor
		test.verifyFalse(new ProfileSkill(1L), new ProfileSkill(2L));

		//Test #7: All required values by constructor
		ProfileSkill odd = new ProfileSkill(new ProfileChampion(1L), new Skill(1L));
		ProfileSkill even = new ProfileSkill(new ProfileChampion(2L), new Skill(2L));
		test.verifyFalse(odd, even);

		//Test #8: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #9: User Value
		odd = new ProfileSkill();
		odd.setUserSkill(new ProfileChampion(1L));
		even = new ProfileSkill();
		even.setUserSkill(new ProfileChampion(2L));
		test.verifyFalse(odd, even);

		//Test #10: Skill Value
		odd = new ProfileSkill();
		odd.setSkill(new Skill(1L));
		even = new ProfileSkill();
		even.setSkill(new Skill(2L));
		test.verifyFalse(odd, even);

	}

	private ProfileSkill build() {
		ProfileSkill profileSkill = new ProfileSkill();
		profileSkill.setId(1L);
		profileSkill.setUserSkill(new ProfileChampion(1L));
		profileSkill.setSkill(new Skill(1L));
		return profileSkill;
	}

}

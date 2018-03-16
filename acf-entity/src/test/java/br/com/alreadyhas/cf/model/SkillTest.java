package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class SkillTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Skill odd = new Skill();
		Skill even = new Skill();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Skill(new Persona(1L), "Fire ball");
		even = new Skill(new Persona(1L), "Fire ball");
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Skill(1L), new Skill(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

		//Test #6: Others
		odd = new Skill(1L);
		even = new Skill(1L);

		byte[] photoOdd = {1};
		byte[] photoEven = {2};

		odd.setPoints(5);
		odd.setSkillDescription("Fire!");
		odd.setSkillPhoto(photoOdd);

		even.setPoints(6);
		even.setSkillDescription("Water!");
		even.setSkillPhoto(photoEven);

		test.verifyTrue(odd, even);

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #7: Id by constructor
		test.verifyFalse(new Skill(1L), new Skill(2L));

		//Test #8: All required values by constructor
		Skill odd = new Skill(new Persona(1L), "Fire Ball");
		Skill even = new Skill(new Persona(2L), "Water Ball");
		test.verifyFalse(odd, even);

		//Test #9: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #10: Name Value
		odd = new Skill();
		odd.setSkillName("Fire Ball");
		even = new Skill();
		even.setSkillName("Water Ball");
		test.verifyFalse(odd, even);

		//Test #11: Character Value
		odd = new Skill();
		odd.setCharacter(new Persona(1L));
		even = new Skill();
		even.setCharacter(new Persona(2L));
		test.verifyFalse(odd, even);
	}

	private Skill build() {
		Skill skill = new Skill();
		skill.setId(1L);
		skill.setSkillName("Fire Ball");
		skill.setCharacter(new Persona(1L));
		return skill;
	}

}

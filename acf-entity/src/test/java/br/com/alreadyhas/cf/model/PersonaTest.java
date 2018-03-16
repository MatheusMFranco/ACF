package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;
import br.com.alreadyhas.cf.preset.FactionEnum;
import br.com.alreadyhas.cf.preset.GenderEnum;
import br.com.alreadyhas.cf.preset.SpecieEnum;

public class PersonaTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Persona odd = new Persona();
		Persona even = new Persona();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Persona("MaleEatMan", FactionEnum.FANTASTIC.getCode());
		even = new Persona("MaleEatMan", FactionEnum.FANTASTIC.getCode());
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Persona(1L), new Persona(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

		//Test #6: Values that are not required
		odd = new Persona();
		odd.setId(1L);
		odd.setCharacterDescription("The cute bear");
		odd.setAlterEgo("John");
		odd.setCharacterGender(GenderEnum.ALIEN.getCode());
		odd.setCharacterSpecie(SpecieEnum.BEAR.getCode());

		even = new Persona();
		even.setId(1L);
		even.setCharacterDescription("The cute bear");
		even.setAlterEgo("John");
		even.setCharacterGender(GenderEnum.ALIEN.getCode());
		even.setCharacterSpecie(SpecieEnum.BEAR.getCode());

		test.verifyTrue(odd, even);
	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #7: Id by constructor
		test.verifyFalse(new Persona(1L), new Persona(2L));

		//Test #8: All required values by constructor
		Persona odd = new Persona("MaleEatMan", FactionEnum.FANTASTIC.getCode());
		Persona even = new Persona("John Bear", FactionEnum.COSMIC.getCode());
		test.verifyFalse(odd, even);

		//Test #9: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #10: Name Value
		odd = new Persona();
		odd.setCharacterName("Diabrete");
		even = new Persona();
		even.setCharacterName("The Death");
		test.verifyFalse(odd, even);

		//Test #11: Faction Value
		odd = new Persona();
		odd.setCharacterFaction(FactionEnum.FANTASTIC.getCode());
		even = new Persona();
		even.setCharacterFaction(FactionEnum.COSMIC.getCode());
		test.verifyFalse(odd, even);

	}

	private Persona build() {
		Persona character = new Persona();
		character.setId(1L);
		character.setCharacterName("Jack");
		character.setCharacterFaction(FactionEnum.FANTASTIC.getCode());
		return character;
	}

}

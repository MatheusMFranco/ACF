package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;
import br.com.alreadyhas.cf.preset.FactionEnum;
import br.com.alreadyhas.cf.preset.GenderEnum;
import br.com.alreadyhas.cf.preset.SpecieEnum;

public class CharacterTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Character odd = new Character();
		Character even = new Character();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Character("MaleEatMan", FactionEnum.FANTASTIC.getCode());
		even = new Character("MaleEatMan", FactionEnum.FANTASTIC.getCode());
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Character(1L), new Character(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

		//Test #6: Values that are not required
		odd = new Character();
		odd.setId(1L);
		odd.setCharacterDescription("The cute bear");
		odd.setAlterEgo("John");
		odd.setCharacterGender(GenderEnum.ALIEN.getCode());
		odd.setCharacterSpecie(SpecieEnum.BEAR.getCode());

		even = new Character();
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
		test.verifyFalse(new Character(1L), new Character(2L));

		//Test #8: All required values by constructor
		Character odd = new Character("MaleEatMan", FactionEnum.FANTASTIC.getCode());
		Character even = new Character("John Bear", FactionEnum.COSMIC.getCode());
		test.verifyFalse(odd, even);

		//Test #9: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #10: Name Value
		odd = new Character();
		odd.setCharacterName("Diabrete");
		even = new Character();
		even.setCharacterName("The Death");
		test.verifyFalse(odd, even);

		//Test #11: Faction Value
		odd = new Character();
		odd.setCharacterFaction(FactionEnum.FANTASTIC.getCode());
		even = new Character();
		even.setCharacterFaction(FactionEnum.COSMIC.getCode());
		test.verifyFalse(odd, even);

	}

	private Character build() {
		Character Character = new Character();
		Character.setId(1L);
		Character.setCharacterName("Jack");
		Character.setCharacterFaction(FactionEnum.FANTASTIC.getCode());
		return Character;
	}

}

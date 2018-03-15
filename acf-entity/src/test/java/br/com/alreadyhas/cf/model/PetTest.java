package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;
import br.com.alreadyhas.cf.preset.ElementEnum;
import br.com.alreadyhas.cf.preset.FactionEnum;
import br.com.alreadyhas.cf.preset.PetTypeEnum;
import br.com.alreadyhas.cf.preset.SpecieEnum;

public class PetTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Pet odd = new Pet();
		Pet even = new Pet();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Pet("Piruleta", PetTypeEnum.EFFECT.getCode(), ElementEnum.AIR.getCode());
		even = new Pet("Piruleta", PetTypeEnum.EFFECT.getCode(), ElementEnum.AIR.getCode());
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Pet(1L), new Pet(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

		//Test #6: Others
		odd = new Pet(1L);
		even = new Pet(1L);

		byte[] photoOdd = {1};
		byte[] photoEven = {2};

		odd.setAttack(2000);
		odd.setEffect("Can attack directly");
		odd.setLife(2000);
		odd.setPetDescription("The Piruleta can jump among the other pets.");
		odd.setPetFaction(FactionEnum.FANTASTIC.getCode());
		odd.setPetSpecie(SpecieEnum.HUMAN.getCode());
		odd.setPhoto(photoOdd);

		even.setAttack(1000);
		even.setEffect(null);
		even.setLife(3000);
		even.setPetDescription("A cat that loves to steal things.");
		even.setPetFaction(FactionEnum.COSMIC.getCode());
		even.setPetSpecie(SpecieEnum.CAT.getCode());
		even.setPhoto(photoEven);

		test.verifyTrue(odd, even);

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #7: Id by constructor
		test.verifyFalse(new Pet(1L), new Pet(2L));

		//Test #8: All required values by constructor
		Pet odd = new Pet("Piruleta", PetTypeEnum.EFFECT.getCode(), ElementEnum.AIR.getCode());
		Pet even = new Pet("Kato", PetTypeEnum.NORMAL.getCode(), ElementEnum.DARKNESS.getCode());
		test.verifyFalse(odd, even);

		//Test #9: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #10: Name Value
		odd = new Pet();
		odd.setPetName("Piruleta");
		even = new Pet();
		even.setPetName("Kato");
		test.verifyFalse(odd, even);

		//Test #11: Type Value
		odd = new Pet();
		odd.setPetType(PetTypeEnum.EFFECT.getCode());
		even = new Pet();
		even.setPetType(PetTypeEnum.NORMAL.getCode());
		test.verifyFalse(odd, even);

		//Test #12: Element Value
		odd = new Pet();
		odd.setPetElement(ElementEnum.FIRE.getCode());
		even = new Pet();
		even.setPetElement(ElementEnum.WATER.getCode());
		test.verifyFalse(odd, even);
	}

	private Pet build() {
		Pet pet = new Pet();
		pet.setId(1L);
		pet.setPetName("Piruleta");
		pet.setPetElement(ElementEnum.AIR.getCode());
		pet.setPetType(PetTypeEnum.EFFECT.getCode());
		return pet;
	}

}

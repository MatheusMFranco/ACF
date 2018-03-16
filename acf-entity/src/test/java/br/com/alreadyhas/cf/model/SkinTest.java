package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class SkinTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Skin odd = new Skin();
		Skin even = new Skin();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Skin(new Persona(1L), "IceBear");
		even = new Skin(new Persona(1L), "IceBear");
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Skin(1L), new Skin(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

		//Test #6: Others
		odd = new Skin(1L);
		even = new Skin(1L);

		byte[] photoOdd = {1};
		byte[] photoEven = {2};

		odd.setSkinDescription("Ice John Bear");
		odd.setSkinPhoto(photoOdd);

		even.setSkinDescription("Fire John Bear");
		even.setSkinPhoto(photoEven);

		test.verifyTrue(odd, even);

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #7: Id by constructor
		test.verifyFalse(new Skin(1L), new Skin(2L));

		//Test #8: All required values by constructor
		Skin odd = new Skin(new Persona(1L), "IceBear");
		Skin even = new Skin(new Persona(2L), "FireBear");
		test.verifyFalse(odd, even);

		//Test #9: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #10: Name Value
		odd = new Skin();
		odd.setSkinName("IceBear");
		even = new Skin();
		even.setSkinName("FireBear");
		test.verifyFalse(odd, even);

		//Test #11: Character Value
		odd = new Skin();
		odd.setSkinCharacter(new Persona(1L));
		even = new Skin();
		even.setSkinCharacter(new Persona(2L));
		test.verifyFalse(odd, even);
	}

	private Skin build() {
		Skin skin = new Skin();
		skin.setId(1L);
		skin.setSkinName("IceBear");
		skin.setSkinCharacter(new Persona(1L));
		return skin;
	}

}

package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class CatchphraseTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Catchphrase odd = new Catchphrase();
		Catchphrase even = new Catchphrase();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Catchphrase("Oh, yeah!", new Persona());
		even = new Catchphrase("Oh, yeah!", new Persona());
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Catchphrase(1L), new Catchphrase(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());
	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #6: Id by constructor
		test.verifyFalse(new Catchphrase(1L), new Catchphrase(2L));

		//Test #7: All required values by constructor
		Catchphrase odd = new Catchphrase("Oh, yeah!", new Persona(1L));
		Catchphrase even = new Catchphrase("Fiambre!", new Persona(2L));
		test.verifyFalse(odd, even);

		//Test #8: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #9: Phrase Value
		odd = new Catchphrase();
		odd.setPhrase("Hello!");
		even = new Catchphrase();
		even.setPhrase("Ciao!");
		test.verifyFalse(odd, even);

		//Test #10: Character Value
		odd = new Catchphrase();
		odd.setCharacter(new Persona(1L));
		even = new Catchphrase();
		even.setCharacter(new Persona(2L));
		test.verifyFalse(odd, even);

	}

	private Catchphrase build() {
		Catchphrase catchphrase = new Catchphrase();
		catchphrase.setId(1L);
		catchphrase.setPhrase("Hello");
		catchphrase.setCharacter(new Persona());
		return catchphrase;
	}

}

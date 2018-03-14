package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class DeckTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Deck odd = new Deck();
		Deck even = new Deck();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Deck(new ProfileChampion(1L), new Card(1L));
		even = new Deck(new ProfileChampion(1L), new Card(1L));
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Deck(1L), new Deck(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #6: Id by constructor
		test.verifyFalse(new Deck(1L), new Deck(2L));

		//Test #7: All required values by constructor
		Deck odd = new Deck(new ProfileChampion(1L), new Card(1L));
		Deck even = new Deck(new ProfileChampion(2L), new Card(2L));
		test.verifyFalse(odd, even);

		//Test #8: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #9: ProfileChampion Value
		odd = new Deck();
		odd.setUserDeck(new ProfileChampion(1L));
		even = new Deck();
		even.setUserDeck(new ProfileChampion(2L));
		test.verifyFalse(odd, even);

		//Test #10: Card Value
		odd = new Deck();
		odd.setCardDeck(new Card(1L));
		even = new Deck();
		even.setCardDeck(new Card(2L));
		test.verifyFalse(odd, even);

	}

	private Deck build() {
		Deck Deck = new Deck();
		Deck.setId(1L);
		Deck.setUserDeck(new ProfileChampion(1L));
		Deck.setCardDeck(new Card(1L));
		return Deck;
	}

}

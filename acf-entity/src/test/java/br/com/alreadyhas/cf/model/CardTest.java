package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;
import br.com.alreadyhas.cf.preset.CardTypeEnum;
import br.com.alreadyhas.cf.preset.ElementEnum;

public class CardTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Card odd = new Card();
		Card even = new Card();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Card("TWIST", ElementEnum.AIR.getCode(), CardTypeEnum.BACKGROUND.getCode());
		even = new Card("TWIST", ElementEnum.AIR.getCode(), CardTypeEnum.BACKGROUND.getCode());
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Card(1L), new Card(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

		//Test #6: Values that are not required
		odd = new Card();
		odd.setId(1L);
		byte[] photoOdd = {1,3};
		odd.setCardDescription("A");
		odd.setLevel(2);
		odd.setPhoto(photoOdd);
		odd.setPoints(2);
		odd.setRequiredCard(1);
		odd.setRequiredPet(1);

		even = new Card();
		even.setId(1L);
		byte[] photoEven = {2,1};
		even.setCardDescription("B");
		even.setLevel(3);
		even.setPhoto(photoEven);
		even.setPoints(3);
		even.setRequiredCard(2);
		even.setRequiredPet(2);

		test.verifyTrue(odd, even);
	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #7: Id by constructor
		test.verifyFalse(new Card(1L), new Card(2L));

		//Test #8: All required values by constructor
		Card odd = new Card("TWIST", ElementEnum.AIR.getCode(), CardTypeEnum.BACKGROUND.getCode());
		Card even = new Card("TWISTER", ElementEnum.DARKNESS.getCode(), CardTypeEnum.CONTINUOUS.getCode());
		test.verifyFalse(odd, even);

		//Test #9: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #10: Name Value
		odd = new Card();
		odd.setCardName("TWIST");
		even = new Card();
		even.setCardName("TWISTER");
		test.verifyFalse(odd, even);

		//Test #11: Element Value (ElementEnumTest apart)
		odd = new Card();
		odd.setElement(ElementEnum.AIR.getCode());
		even = new Card();
		even.setElement(ElementEnum.DARKNESS.getCode());
		test.verifyFalse(odd, even);

		//Test #12: Type Value (CardTypeEnum apart)
		odd = new Card();
		odd.setType(CardTypeEnum.BACKGROUND.getCode());
		even = new Card();
		even.setType(CardTypeEnum.CONTINUOUS.getCode());
		test.verifyFalse(odd, even);

	}

	private Card build() {
		Card card = new Card();
		card.setId(1L);
		card.setCardName("TWIST");
		card.setElement(ElementEnum.AIR.getCode());
		card.setType(CardTypeEnum.BACKGROUND.getCode());
		return card;
	}

}

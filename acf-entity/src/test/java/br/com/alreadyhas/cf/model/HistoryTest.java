package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class HistoryTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		History odd = new History();
		History even = new History();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new History(new ProfileChampion(1L), new ProfileChampion(1L));
		even = new History(new ProfileChampion(1L), new ProfileChampion(1L));
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new History(1L), new History(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

		//Test #6: Moves
		odd = new History(1L);
		even = new History(1L);
		byte[] movesOdd = {1};
		byte[] movesEven = {2};
		odd.setMoves(movesOdd);
		even.setMoves(movesEven);
		test.verifyTrue(odd, even);

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #7: Id by constructor
		test.verifyFalse(new History(1L), new History(2L));

		//Test #8: All required values by constructor
		History odd = new History(new ProfileChampion(1L), new ProfileChampion(1L));
		History even = new History(new ProfileChampion(2L), new ProfileChampion(2L));
		test.verifyFalse(odd, even);

		//Test #9: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #10: UserRed Value
		odd = new History();
		odd.setUserRed(new ProfileChampion(1L));
		even = new History();
		even.setUserRed(new ProfileChampion(2L));
		test.verifyFalse(odd, even);

		//Test #11: UserBlue Value
		odd = new History();
		odd.setUserBlue(new ProfileChampion(1L));
		even = new History();
		even.setUserBlue(new ProfileChampion(2L));
		test.verifyFalse(odd, even);

	}

	private History build() {
		History history = new History();
		history.setId(1L);
		history.setUserRed(new ProfileChampion(1L));
		history.setUserBlue(new ProfileChampion(1L));
		return history;
	}

}

package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;

public class FriendshipTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		Friendship odd = new Friendship();
		Friendship even = new Friendship();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new Friendship(1L, 1L);
		even = new Friendship(1L, 1L);
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new Friendship(1L), new Friendship(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #6: Id by constructor
		test.verifyFalse(new Friendship(1L), new Friendship(2L));

		//Test #7: All required values by constructor
		Friendship odd = new Friendship(1L, 1L);
		Friendship even = new Friendship(2L, 2L);
		test.verifyFalse(odd, even);

		//Test #8: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #9: Friend Value
		odd = new Friendship();
		odd.setFriend(1L);
		even = new Friendship();
		even.setFriend(2L);
		test.verifyFalse(odd, even);

		//Test #10: FriendShipUser Value
		odd = new Friendship();
		odd.setFriendShipUser(1L);
		even = new Friendship();
		even.setFriendShipUser(2L);
		test.verifyFalse(odd, even);

	}

	private Friendship build() {
		Friendship friendship = new Friendship();
		friendship.setId(1L);
		friendship.setFriend(1L);
		friendship.setFriendShipUser(1L);
		return friendship;
	}

}

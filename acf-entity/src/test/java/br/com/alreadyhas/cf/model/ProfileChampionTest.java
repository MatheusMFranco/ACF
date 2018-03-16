package br.com.alreadyhas.cf.model;

import org.junit.Test;

import br.com.alreadyhas.cf.base.ModelTest;
import br.com.alreadyhas.cf.base.TestVerify;
import br.com.alreadyhas.cf.preset.FactionEnum;
import br.com.alreadyhas.cf.preset.UserStatusEnum;

public class ProfileChampionTest implements ModelTest{

	@Test
	public void verifyEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #1: None values
		ProfileChampion odd = new ProfileChampion();
		ProfileChampion even = new ProfileChampion();
		test.verifyTrue(odd, even);

		//Test #2: All required values by constructor
		odd = new ProfileChampion("John Smitch", "acf@alreadyhas.com.br", "TheDoctor");
		even = new ProfileChampion("John Smitch", "acf@alreadyhas.com.br", "TheDoctor");
		test.verifyTrue(odd, even);

		//Test #3: Id by set
		odd.setId(1L);
		even.setId(1L);
		test.verifyTrue(odd, even);

		//Test #4: Id by constructor
		test.verifyTrue(new ProfileChampion(1L), new ProfileChampion(1L));

		//Test #5: All required values by Set
		test.verifyTrue(build(), build());

		//Test #6: Others
		odd = new ProfileChampion(1L);
		even = new ProfileChampion(1L);

		byte[] photoOdd = {1};
		byte[] photoEven = {2};

		odd.setCash(8);
		odd.setCoin(8001);
		odd.setDescription(null);
		odd.setEncripted(Boolean.FALSE);
		odd.setExperience(100.0);
		odd.setFaction(FactionEnum.COSMIC.getCode());
		odd.setLevel(8);
		odd.setPassword("1234");
		odd.setStatus(UserStatusEnum.ACTIVE.getCode());
		odd.setPhoto(photoOdd);

		even.setCash(6);
		even.setCoin(9001);
		even.setDescription("Hello!");
		even.setEncripted(Boolean.TRUE);
		even.setExperience(30.0);
		even.setFaction(FactionEnum.FANTASTIC.getCode());
		even.setLevel(10);
		even.setPassword("****");
		odd.setStatus(UserStatusEnum.NEW.getCode());
		even.setPhoto(photoEven);

		test.verifyTrue(odd, even);

	}

	@Test
	public void verifyNotEquals(){

		TestVerify test = TestVerify.getInstance();

		//Test #7: Id by constructor
		test.verifyFalse(new ProfileChampion(1L), new ProfileChampion(2L));

		//Test #8: All required values by constructor
		ProfileChampion odd = new ProfileChampion("John Smitch", "acf@alreadyhas.com.br", "TheDoctor");
		ProfileChampion even = new ProfileChampion("Yugi Muto", "yugi@alreadyhas.com.br", "Dark Magician");
		test.verifyFalse(odd, even);

		//Test #9: Id by set
		odd.setId(1L);
		even.setId(2L);
		test.verifyFalse(odd, even);

		//Test #10: Name Value
		odd = new ProfileChampion();
		odd.setName("John Smitch");
		even = new ProfileChampion();
		even.setName("Yugi Muto");
		test.verifyFalse(odd, even);

		//Test #11: E-mail Value
		odd = new ProfileChampion();
		odd.setEmail("acf@alreadyhas.com.br");
		even = new ProfileChampion();
		even.setEmail("yugi@alreadyhas.com.br");
		test.verifyFalse(odd, even);

		//Test #12: Login Value
		odd = new ProfileChampion();
		odd.setLogin("TheDoctor");
		even = new ProfileChampion();
		even.setLogin("DarkMagician");
		test.verifyFalse(odd, even);
	}

	private ProfileChampion build() {
		ProfileChampion profileChampion = new ProfileChampion();
		profileChampion.setId(1L);
		profileChampion.setName("John Smitch");
		profileChampion.setEmail("acf@alreadyhas.com.br");
		profileChampion.setLogin("TheDoctor");
		return profileChampion;
	}

}

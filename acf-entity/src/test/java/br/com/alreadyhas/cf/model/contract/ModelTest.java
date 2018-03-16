package br.com.alreadyhas.cf.model.contract;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.alreadyhas.cf.model.Achievement;
import br.com.alreadyhas.cf.model.Card;
import br.com.alreadyhas.cf.model.Catchphrase;
import br.com.alreadyhas.cf.model.Deck;
import br.com.alreadyhas.cf.model.Friendship;
import br.com.alreadyhas.cf.model.History;
import br.com.alreadyhas.cf.model.Persona;
import br.com.alreadyhas.cf.model.Pet;
import br.com.alreadyhas.cf.model.ProfileAchievement;
import br.com.alreadyhas.cf.model.ProfileChampion;
import br.com.alreadyhas.cf.model.ProfileSkill;
import br.com.alreadyhas.cf.model.Skill;
import br.com.alreadyhas.cf.model.Skin;
import br.com.alreadyhas.cf.util.DateUtil;

public class ModelTest{

	private List<String> phrasesTest      = new ArrayList<String>();
	private List<String> phrasesExpecteds = new ArrayList<String>();

	@Test
	public void verifyToString(){

		for(Long i = 1L; i <= 10; i++){
			createToStringTest(new Achievement(i)        );
			createToStringTest(new Card(i)               );
			createToStringTest(new Catchphrase(i)        );
			createToStringTest(new Deck(i)               );
			createToStringTest(new Friendship(i)         );
			createToStringTest(new History(i)            );
			createToStringTest(new Persona(i)            );
			createToStringTest(new Pet(i)                );
			createToStringTest(new ProfileAchievement(i) );
			createToStringTest(new ProfileChampion(i)    );
			createToStringTest(new ProfileSkill(i)       );
			createToStringTest(new Skill(i)              );
			createToStringTest(new Skin(i)               );
		}

		assertArrayEquals(phrasesTest.toArray(), phrasesExpecteds.toArray());
	}

	private void createToStringTest(Model model) {
		StringBuilder modelToString = new StringBuilder(" | Date: ")
		.append(DateUtil.getDefaultFormat(new Date()))
		.append(" | Class: ")
		.append(model.getClass().getSimpleName())
		.append(" | ID: ")
		.append(model.getId())
		.append(" | ");

		phrasesTest.add(modelToString.toString());
		phrasesExpecteds.add(model.toString());
	}

}

package br.com.alreadyhas.cf.model.contract;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.alreadyhas.cf.model.Card;
import br.com.alreadyhas.cf.model.Catchphrase;
import br.com.alreadyhas.cf.model.Character;
import br.com.alreadyhas.cf.util.DateUtil;

public class ModelTest{

	@Test
	public void verifyToString(){

		List<String> phrasesTest      = new ArrayList<String>();
		List<String> phrasesExpecteds = new ArrayList<String>();

		for(Long i = 1L; i <= 10; i++){
			createToStringTest(new Card(i),             "Card",        phrasesTest, phrasesExpecteds, i);
			createToStringTest(new Catchphrase(i),      "Catchphrase", phrasesTest, phrasesExpecteds, i);
			createToStringTest(new Character(i),        "Character",   phrasesTest, phrasesExpecteds, i);
		}

		assertArrayEquals(phrasesTest.toArray(), phrasesExpecteds.toArray());
	}

	private void createToStringTest(Model model, String name, List<String> phrasesTest, List<String> phrasesExpecteds, Long i) {
		StringBuilder modelToString = new StringBuilder(" | Date: ")
		.append(DateUtil.getDefaultFormat(new Date()))
		.append(" | Class: ")
		.append(name)
		.append(" | ID: ")
		.append(model.getId())
		.append(" | ");

		phrasesTest.add(modelToString.toString());
		phrasesExpecteds.add(model.toString());
	}

}

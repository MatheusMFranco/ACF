package br.com.alreadyhas.cf.model.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alreadyhas.cf.util.ConfigurationUtil;

public class CreateEntityManager {

	private CreateEntityManager() {/**/}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(ConfigurationUtil.DATA_BASE);
		factory.createEntityManager();
		factory.close();
	}

}

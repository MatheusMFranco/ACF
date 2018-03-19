package br.com.alreadyhas.cf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alreadyhas.cf.model.Persona;
import br.com.alreadyhas.cf.repository.PersonaRepository;

@Service
public class PersonaService{

	@Autowired
	private PersonaRepository repository;

	public Iterable<Persona> listAll() {
		return repository.findAll();
	}

}

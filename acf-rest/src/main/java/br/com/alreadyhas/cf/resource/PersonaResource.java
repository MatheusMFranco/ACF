package br.com.alreadyhas.cf.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alreadyhas.cf.model.Persona;
import br.com.alreadyhas.cf.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaResource {

	@Autowired
	private PersonaService personaService;

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Persona> listAll(){
		return personaService.listAll();
	}

}

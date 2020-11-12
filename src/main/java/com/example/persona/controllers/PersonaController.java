package com.example.persona.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persona.entities.Persona;
import com.example.persona.services.PersonaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "apiPrueba/version1/personas")
public class PersonaController {

	private PersonaService personaService;
	
	public PersonaController(PersonaService personaService) 
	{
		this.personaService = personaService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try{
			return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());	
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error en la funcion getAll\"}");
			
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne (@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error : Error en la funcion getOne que se condice con findById en el servicio}");
		}		
	}
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Persona entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{Error : Error en la funcion save que se condice con save en el servicio}");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{Error : Error en la funcion update que se condice con update en el servicio}");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{Error en la funcion delete}");
		} 
	}
	
}

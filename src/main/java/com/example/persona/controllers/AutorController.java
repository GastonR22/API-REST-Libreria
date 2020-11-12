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

import com.example.persona.entities.Autor;
import com.example.persona.services.AutorService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "apiPrueba/version1/autores")
public class AutorController {

	private AutorService autorService;
	
	public AutorController(AutorService autorService){
		this.autorService = autorService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(autorService.findAll());			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error en la funcion getAll(Controller) , getAll(Service)\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id){	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(autorService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error en la funcion findOne(Controller) , findById(Service)\"}");
		}
	}

	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Autor entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(autorService.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error en la funcion save(Controller) , save(Service)\"}");
		} 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id , @RequestBody Autor entity){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(autorService.update(id, entity));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("{\"Error\":\"Error en la funcion update(Controller) , update(Service)\"}");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
	try {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autorService.delete(id));
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error en la funcion delete(Controller) , delete(Service)\"}");
	}	
	}
	
}

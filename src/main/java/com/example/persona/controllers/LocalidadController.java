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

import com.example.persona.entities.Localidad;
import com.example.persona.services.LocalidadService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "apiPrueba/version1/localidades")
public class LocalidadController {
	
	private LocalidadService localidadService;
	
	public LocalidadController(LocalidadService localidadService){
		this.localidadService = localidadService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(localidadService.findAll());			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error en la funcion getAll(Controller) , getAll(Service)\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id){	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(localidadService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error en la funcion findOne(Controller) , findById(Service)\"}");
		}
	}

	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Localidad entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(localidadService.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error en la funcion save(Controller) , save(Service)\"}");
		} 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id , @RequestBody Localidad entity){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(localidadService.update(id, entity));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("{\"Error\":\"Error en la funcion update(Controller) , update(Service)\"}");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
	try {
		return ResponseEntity.status(HttpStatus.OK).body(localidadService.delete(id));
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error en la funcion delete(Controller) , delete(Service)\"}");
	}	
	}
	
	
	
	
}

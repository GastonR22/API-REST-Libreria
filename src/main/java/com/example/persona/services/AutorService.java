package com.example.persona.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.persona.entities.Autor;
import com.example.persona.repositories.AutorRepository;


@Service
public class AutorService implements BaseService<Autor> {

	private AutorRepository autorRepository;

	public AutorService(AutorRepository autorRepository){
		
		this.autorRepository  = autorRepository;
		
	}

	@Override
	@Transactional 
	public List<Autor> findAll() throws Exception {	
		try {
			List<Autor> entidades = autorRepository.findAll();
			return entidades;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	@Transactional
	public Autor findById(Long id) throws Exception {
		try {
			Optional<Autor> entidad = autorRepository.findById(id);
			Autor autor = entidad.get();
			return autor;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Autor save(Autor entity) throws Exception {	
		try {
			entity = autorRepository.save(entity);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Autor update(Long id, Autor entity) throws Exception {
		try {		
			Optional<Autor> entidadOpcional = autorRepository.findById(id);		
			Autor autor = entidadOpcional.get();
			autor = autorRepository.save(entity);
			return autor;
			/*Cuando haces un put, el JSON debe ir ademas del id en el @PathVariable, se lo tenes que mandar en la consulta como "id" : 1 (ejemplo)*/
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {
			if(autorRepository.existsById(id)){
				autorRepository.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
}

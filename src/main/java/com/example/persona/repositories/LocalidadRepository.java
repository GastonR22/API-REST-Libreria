package com.example.persona.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persona.entities.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long>{

}

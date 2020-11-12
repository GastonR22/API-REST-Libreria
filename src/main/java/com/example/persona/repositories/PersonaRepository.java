package com.example.persona.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persona.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Long>{

}

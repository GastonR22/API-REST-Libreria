package com.example.persona.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persona.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}

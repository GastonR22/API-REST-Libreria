package com.example.persona.entities;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="libro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class Libro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="fecha")
	private int fecha;

	@Column(name="pagina")
	private int paginas;
	
	@Column(name="titulo")
	private String titulo;
	
	@ManyToMany
	@JoinTable(
			name="libro_autor",
			joinColumns = @JoinColumn(name="libro_id"),
			inverseJoinColumns = @JoinColumn(name="autor_id") 
			)
	private List<Autor> autores = new ArrayList<Autor>();
	
}

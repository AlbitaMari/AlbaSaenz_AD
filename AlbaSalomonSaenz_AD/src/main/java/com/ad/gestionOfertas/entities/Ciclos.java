package com.ad.gestionOfertas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="ciclos")
public class Ciclos {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Pattern(regexp="^\\D{1,60}$",message="El nombre no puede contener nÃºmeros")
	@NotEmpty(message="Debe introducir un nombre")
	@Size(min=1,max=60,message="El nombre debe tener de 1 a 60 caracteres")
	@Column(name="nombre", nullable = false, length = 60 )
	private String nombre;
	
	@NotEmpty(message="Debe introducir un tipo")
	@Size(min=1,max=40,message="El tipo debe tener de 1 a 40 caracteres")
	@Column(name="tipo", nullable = false, length = 40 )
	private String tipo;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="cicloId")
	private List<Usuarios> alumnosList = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cicloId")
	private List<Noticias> noticiasList = new ArrayList<>();

	public Ciclos() {
		super();
	}

	public Ciclos(int id,
			@Pattern(regexp = "^\\D{1,60}$", message = "El nombre no puede contener nÃºmeros") @NotEmpty(message = "Debe introducir un nombre") @Size(min = 1, max = 60, message = "El nombre debe tener de 1 a 60 caracteres") String nombre,
			@NotEmpty(message = "Debe introducir un tipo") @Size(min = 1, max = 40, message = "El tipo debe tener de 1 a 40 caracteres") String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Usuarios> getAlumnosList() {
		return alumnosList;
	}

	public void setAlumnosList(List<Usuarios> alumnosList) {
		this.alumnosList = alumnosList;
	}

	public List<Noticias> getNoticiasList() {
		return noticiasList;
	}

	public void setNoticiasList(List<Noticias> noticiasList) {
		this.noticiasList = noticiasList;
	}

}

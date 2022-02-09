package com.ad.gestionOfertas.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="noticias")
public class Noticias {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="Debe introducir un titulo")
	@Size(min=1,max=50,message="El titulo debe tener de 1 a 50 caracteres")
	@Column(name="titulo", nullable = false, length = 50 )
	private String titulo;
	
	@NotEmpty(message="Debe introducir una descripcion")
	@Size(min=1,max=255,message="El titulo debe tener de 1 a 255 caracteres")
	@Column(name="descripcion", nullable = false, length = 255 )
	private String descripcion;
	
	@Column(name="imagen", nullable = false)
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="ciclo_id")
	private Ciclos cicloId;

	public Noticias() {
		super();
	}

	public Noticias(int id,
			@NotEmpty(message = "Debe introducir un titulo") @Size(min = 1, max = 50, message = "El titulo debe tener de 1 a 50 caracteres") String titulo,
			@NotEmpty(message = "Debe introducir una descripcion") @Size(min = 1, max = 255, message = "El titulo debe tener de 1 a 255 caracteres") String descripcion,
			String imagen, Ciclos cicloId) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.cicloId = cicloId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Ciclos getCicloId() {
		return cicloId;
	}

	public void setCicloId(Ciclos cicloId) {
		this.cicloId = cicloId;
	}

}

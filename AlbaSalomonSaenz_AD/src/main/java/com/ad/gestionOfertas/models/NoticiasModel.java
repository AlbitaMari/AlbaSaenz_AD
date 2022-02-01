package com.ad.gestionOfertas.models;

import com.ad.gestionOfertas.entities.Ciclos;

public class NoticiasModel {

	private int id;
	private String titulo;
	private String descripcion;
	private String imagen;
	private Ciclos cicloId;

	public NoticiasModel() {
		super();
	}

	public NoticiasModel(int id, String titulo, String descripcion, String imagen, Ciclos cicloId) {
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

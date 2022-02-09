package com.ad.gestionOfertas.models;

import java.util.Date;

import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.entities.Usuarios;

public class OfertasModel {
	
	private int id;
	private String titular;
	private String descripcion;
	private String requisitos;
	private Date fechaMax;
	private int numCandidatos;
	private Usuarios rrhhid;
	private Ciclos cicloId;
	
	public OfertasModel() {
		super();
	}

	public OfertasModel(int id, String titular, String descripcion, String requisitos, Date fechaMax, int numCandidatos,
			Usuarios rrhhid, Ciclos cicloId) {
		super();
		this.id = id;
		this.titular = titular;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.fechaMax = fechaMax;
		this.numCandidatos = numCandidatos;
		this.rrhhid = rrhhid;
		this.cicloId = cicloId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public int getNumCandidatos() {
		return numCandidatos;
	}

	public void setNumCandidatos(int numCandidatos) {
		this.numCandidatos = numCandidatos;
	}

	public Usuarios getRrhhid() {
		return rrhhid;
	}

	public void setRrhhid(Usuarios rrhhid) {
		this.rrhhid = rrhhid;
	}

	public Date getFechaMax() {
		return fechaMax;
	}

	public void setFechaMax(Date fechaMax) {
		this.fechaMax = fechaMax;
	}

	public Ciclos getCicloId() {
		return cicloId;
	}

	public void setCicloId(Ciclos cicloId) {
		this.cicloId = cicloId;
	}
	
}

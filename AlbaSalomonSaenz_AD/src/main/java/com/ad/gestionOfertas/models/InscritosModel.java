package com.ad.gestionOfertas.models;

import java.util.Date;

import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.entities.Usuarios;

public class InscritosModel {

	private int id;
	private Usuarios idAlumno;
	private Ofertas idOferta;
	private Date fecha_inscripcion;

	public InscritosModel() {
		super();
	}

	public InscritosModel(int id, Usuarios idAlumno, Ofertas idOferta, Date fecha_inscripcion) {
		super();
		this.id = id;
		this.idAlumno = idAlumno;
		this.idOferta = idOferta;
		this.fecha_inscripcion = fecha_inscripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuarios getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Usuarios idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Ofertas getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Ofertas idOferta) {
		this.idOferta = idOferta;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}

}

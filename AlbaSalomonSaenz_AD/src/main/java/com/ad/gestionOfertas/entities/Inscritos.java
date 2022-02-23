package com.ad.gestionOfertas.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="inscritos")
public class Inscritos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idAlumno")
	private Usuarios idAlumno;
	
	@ManyToOne
	@JoinColumn(name="idOferta")
	private Ofertas idOferta;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inscripcion")
	private Date fecha_inscripcion;

	public Inscritos() {
		super();
	}

	public Inscritos(int id, Usuarios idAlumno, Ofertas idOferta, @NotEmpty Date fecha_inscripcion) {
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

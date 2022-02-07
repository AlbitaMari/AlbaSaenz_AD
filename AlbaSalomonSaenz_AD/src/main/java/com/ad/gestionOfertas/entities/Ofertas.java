package com.ad.gestionOfertas.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ofertas")
public class Ofertas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NotEmpty(message = "Debe introducir un titular")
	@Size(min = 1, max = 60, message = "El titulo debe tener de 1 a 60 caracteres")
	@Column(name = "titular", nullable = false, length = 60)
	private String titular;

	@NotEmpty(message = "Debe introducir una descripcion")
	@Size(min = 1, max = 255, message = "El titulo debe tener de 1 a 255 caracteres")
	@Column(name = "descripcion", nullable = false, length = 255)
	private String descripcion;

	@Lob
	@NotEmpty
	@Column(name = "requisitos")
	private String requisitos;

	@NotNull
	@Column(name = "numCandidatos")
	private int numCandidatos;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaMax", nullable = false)
	private Date fechaMax;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOferta")
	private List<Inscritos> inscritosList;

	@ManyToOne
	@JoinColumn(name = "rrhhid")
	private Usuarios rrhhid;

	public Ofertas() {
		super();
	}

	public Ofertas(int id,
			@NotEmpty(message = "Debe introducir un titular") @Size(min = 1, max = 60, message = "El titulo debe tener de 1 a 60 caracteres") String titular,
			@NotEmpty(message = "Debe introducir una descripcion") @Size(min = 1, max = 255, message = "El titulo debe tener de 1 a 255 caracteres") String descripcion,
			@NotEmpty String requisitos, @NotNull int numCandidatos, Usuarios rrhhid) {
		super();
		this.id = id;
		this.titular = titular;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.numCandidatos = numCandidatos;
		this.rrhhid = rrhhid;
	}

	public Ofertas(int id,
			@NotEmpty(message = "Debe introducir un titular") @Size(min = 1, max = 60, message = "El titulo debe tener de 1 a 60 caracteres") String titular,
			@NotEmpty(message = "Debe introducir una descripcion") @Size(min = 1, max = 255, message = "El titulo debe tener de 1 a 255 caracteres") String descripcion,
			@NotEmpty String requisitos, @NotNull int numCandidatos, Date fechaMax, Usuarios rrhhid) {
		super();
		this.id = id;
		this.titular = titular;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.numCandidatos = numCandidatos;
		this.fechaMax = fechaMax;
		this.rrhhid = rrhhid;
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
	
}
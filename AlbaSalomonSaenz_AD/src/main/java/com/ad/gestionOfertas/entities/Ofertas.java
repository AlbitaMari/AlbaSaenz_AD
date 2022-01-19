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
import javax.validation.constraints.Size;

@Entity
@Table(name="ofertas")
public class Ofertas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="Debe introducir un titular")
	@Size(min=1,max=60,message="El titulo debe tener de 1 a 60 caracteres")
	@Column(name="titular", nullable = false, length = 60 )
	private String titular;
	
	@NotEmpty(message="Debe introducir una descripcion")
	@Size(min=1,max=255,message="El titulo debe tener de 1 a 255 caracteres")
	@Column(name="descripcion", nullable = false, length = 255 )
	private String descripcion;
	
	@Lob
	@NotEmpty
	@Column(name="requisitos")
	private String requisitos;
	
	@NotEmpty
	@Temporal(TemporalType.DATE)
	@Column(name="fechaMax", nullable = false)
	private Date fechaMax;
	
	@NotEmpty
	@Column(name="numCandidatos")
	private int numCandidatos;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="idOferta")
	private List<Inscritos> inscritosList;
	
	@ManyToOne
	@JoinColumn(name="rrhhid")
	private Usuarios rrhhid;
	

}

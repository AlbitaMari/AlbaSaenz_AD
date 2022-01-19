package com.ad.gestionOfertas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Pattern(regexp="^\\D{1,40}$",message="No puede contener números")
	@NotEmpty(message="Debe introducir un nombre")
	@Size(min=1,max=40,message="El nombre debe tener de 1 a 40 caracteres")
	@Column(name="nombre", nullable = false, length = 40)
	private String nombre;
	
	@Pattern(regexp="^\\D{1,60}$",message="El apellido no puede contener números, también debe empezar en mayúscula y seguir todo en minúsculas")
	@NotEmpty(message="Debe introducir un apellido")
	@Size(min=1,max=60,message="El apellido debe tener de 1 a 60 caracteres")
	@Column(name="apellidos", nullable = false, length = 60 )
	private String apellidos;
	
	private boolean enabled;

	@Column(name="telefono", length=10)
	@NotNull
	@NotEmpty(message="El campo teléfono no puede ir vacío")
	@Size(min=3, max=10, message="El campo teléfono debe tener entre 3 y 60 caracteres")
	private String telefono;
	
	@Email
	@NotNull
	@NotEmpty(message="Debe introducir un email")
	@Size(min=1,max=50,message="El email debe tener de 1 a 60 caracteres")
	@Column(name="email", nullable = false, length = 50 )
	private String email;
	
	@NotEmpty(message="Debe introducir una contraseña")
	@Column(name="password", nullable = false, length = 60)
	private String password;
	
	@Column(name="empresa", length=200)
	private String empresa;
	
	@ManyToOne
	@JoinColumn(name="cicloId")
	private Ciclos cicloId;
	
	@Column(name="role")
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="rrhhid")
	List <Ofertas> rrhh = new ArrayList<>();

	public Usuarios() {
		super();
	}


	public Usuarios(int id,
			@Pattern(regexp = "^\\D{1,40}$", message = "No puede contener números") @NotEmpty(message = "Debe introducir un nombre") @Size(min = 1, max = 40, message = "El nombre debe tener de 1 a 40 caracteres") String nombre,
			@Pattern(regexp = "^\\D{1,60}$", message = "El apellido no puede contener números, también debe empezar en mayúscula y seguir todo en minúsculas") @NotEmpty(message = "Debe introducir un apellido") @Size(min = 1, max = 60, message = "El apellido debe tener de 1 a 60 caracteres") String apellidos,
			boolean enabled,
			@NotNull @NotEmpty(message = "El campo teléfono no puede ir vacío") @Size(min = 3, max = 10, message = "El campo teléfono debe tener entre 3 y 60 caracteres") String telefono,
			@Email @NotNull @NotEmpty(message = "Debe introducir un email") @Size(min = 1, max = 50, message = "El email debe tener de 1 a 60 caracteres") String email,
			@NotEmpty(message = "Debe introducir una contraseña") String password, Ciclos cicloId,
			String role) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.enabled = enabled;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.cicloId = cicloId;
		this.role = role;
	}


	public Usuarios(int id,
			@Pattern(regexp = "^\\D{1,40}$", message = "No puede contener números") @NotEmpty(message = "Debe introducir un nombre") @Size(min = 1, max = 40, message = "El nombre debe tener de 1 a 40 caracteres") String nombre,
			@Pattern(regexp = "^\\D{1,60}$", message = "El apellido no puede contener números, también debe empezar en mayúscula y seguir todo en minúsculas") @NotEmpty(message = "Debe introducir un apellido") @Size(min = 1, max = 60, message = "El apellido debe tener de 1 a 60 caracteres") String apellidos,
			boolean enabled,
			@NotNull @NotEmpty(message = "El campo teléfono no puede ir vacío") @Size(min = 3, max = 10, message = "El campo teléfono debe tener entre 3 y 60 caracteres") String telefono,
			@Email @NotNull @NotEmpty(message = "Debe introducir un email") @Size(min = 1, max = 50, message = "El email debe tener de 1 a 60 caracteres") String email,
			@NotEmpty(message = "Debe introducir una contraseña") String password, String empresa, String role) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.enabled = enabled;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.empresa = empresa;
		this.role = role;
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


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return email;
	}
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public Ciclos getCicloID() {
		return cicloId;
	}


	public void setCicloID(Ciclos cicloID) {
		this.cicloId = cicloID;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}



}

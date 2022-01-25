package com.ad.gestionOfertas.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.gestionOfertas.entities.Usuarios;

@Repository("usuariosRepository")
public interface UsuariosRepository extends JpaRepository<Usuarios,Serializable> {
	public Usuarios findUserByEmail(String email);
	public List<Usuarios> findUserByRole(String role);
	public Usuarios findUserById(int id);
}

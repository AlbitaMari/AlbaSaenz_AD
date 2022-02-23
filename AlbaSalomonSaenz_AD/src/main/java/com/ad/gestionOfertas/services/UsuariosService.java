package com.ad.gestionOfertas.services;

import java.util.List;

import javax.validation.Valid;

import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.models.UsuariosModel;

public interface UsuariosService {
	
	Usuarios findUserByEmail(String email);
	Usuarios registerUser(UsuariosModel usuariosModel);
	Usuarios transform(UsuariosModel usuariosModel);
	UsuariosModel transform(Usuarios usuarios);
	Usuarios editUser(UsuariosModel usuario);
	List<UsuariosModel> listAllUsers(String role);
	Usuarios findUserById(int id);
	public void deleteUser(int id) throws Exception;
	Usuarios updateUser(UsuariosModel usuariosModel);
	Usuarios activeUser(UsuariosModel usuarioModel);
	Usuarios deactiveUser(UsuariosModel usuarioModel);
	Usuarios createUser(UsuariosModel usuarioModel);
	Usuarios createrUser(UsuariosModel usuarioModel);
	List<Usuarios> findUserByCicloId(Ciclos cicloId);
	
}

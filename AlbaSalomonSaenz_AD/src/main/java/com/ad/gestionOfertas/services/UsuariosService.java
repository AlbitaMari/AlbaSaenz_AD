package com.ad.gestionOfertas.services;

import org.springframework.stereotype.Service;

import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.models.UsuariosModel;

public interface UsuariosService {
	
	Usuarios findUserByEmail(String email);
	Usuarios registerUser(UsuariosModel usuariosModel);
	Usuarios transform(UsuariosModel usuariosModel);
	UsuariosModel transform(Usuarios usuarios);
	
}

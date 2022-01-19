package com.ad.gestionOfertas.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.models.UsuariosModel;
import com.ad.gestionOfertas.services.UsuariosService;
import com.ad.gestionOfertas.repositories.UsuariosRepository;

@Service("usuariosServiceImpl")
public class UsuariosServiceImpl implements UsuariosService {
	
	@Autowired
	@Qualifier("usuariosRepository")
	private UsuariosRepository usuariosRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Usuarios findUserByEmail(String email) {
		return usuariosRepository.findUserByEmail(email);
	}
		
	@Override
	public Usuarios registerUser(UsuariosModel usuariosModel) {
		usuariosModel.setPassword(passwordEncoder.encode(usuariosModel.getPassword()));
		return usuariosRepository.save(transform(usuariosModel));
	}

	@Override
	public Usuarios transform(UsuariosModel usuariosModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usuariosModel, Usuarios.class);
	}

	@Override
	public UsuariosModel transform(Usuarios usuarios) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usuarios, UsuariosModel.class);
	}
	
}

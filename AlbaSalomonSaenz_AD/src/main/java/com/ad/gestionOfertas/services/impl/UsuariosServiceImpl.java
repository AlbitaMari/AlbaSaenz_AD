package com.ad.gestionOfertas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public Usuarios editUser(UsuariosModel usuario) {
		return usuariosRepository.save(transform(usuario));
	}
	
	
	@Override
	public List<UsuariosModel> listAllUsers(String role) {
		return usuariosRepository.findUserByRole(role).stream().
				map(c->transform(c)).collect(Collectors.toList());
	}
	
	@Override
	public Usuarios findUserById(int id) {
		return usuariosRepository.findUserById(id);
	}
	
	@Override
	public void deleteUser(int id) throws Exception {
		Usuarios usuario = usuariosRepository.findUserById(id);
		usuariosRepository.delete(usuario);
	}

	@Override
	public Usuarios updateUser(UsuariosModel usuariosModel) {
		usuariosRepository.findUserById(usuariosModel.getId());
		usuariosModel.setPassword(passwordEncoder.encode(usuariosModel.getPassword()));
		return usuariosRepository.save(transform(usuariosModel));
	}

	@Override
	public Usuarios activeUser(UsuariosModel usuarioModel) {
		usuarioModel.setEnabled(true);
		return usuariosRepository.save(transform(usuarioModel));
	}

	@Override
	public Usuarios deactiveUser(UsuariosModel usuarioModel) {
		usuarioModel.setEnabled(false);
		return usuariosRepository.save(transform(usuarioModel));
	}

	@Override
	public Usuarios createUser(UsuariosModel usuariosModel) {
		usuariosModel.setPassword(passwordEncoder.encode(usuariosModel.getPassword()));
		return usuariosRepository.save(transform(usuariosModel));
	}
	
	@Override
	public Usuarios createrUser(UsuariosModel usuariosModel) {
		usuariosModel.setPassword(passwordEncoder.encode(usuariosModel.getPassword()));
		return usuariosRepository.save(transform(usuariosModel));
	}





}

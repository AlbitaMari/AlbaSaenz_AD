package com.ad.gestionOfertas.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.gestionOfertas.entities.Inscritos;
import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.models.InscritosModel;
import com.ad.gestionOfertas.models.OfertasModel;
import com.ad.gestionOfertas.models.UsuariosModel;
import com.ad.gestionOfertas.repositories.InscritosRepository;
import com.ad.gestionOfertas.services.InscritosService;
import com.ad.gestionOfertas.services.OfertasService;
import com.ad.gestionOfertas.services.UsuariosService;

@Service
public class InscritosServiceImpl implements InscritosService {
	
	@Autowired
	private InscritosRepository inscritosRepository;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private OfertasService ofertasService;
	
	@Override
	public Inscritos createInscrito(InscritosModel inscritosModel) {
		return inscritosRepository.save(transform(inscritosModel));
	}


	@Override
	public Inscritos transform(InscritosModel inscritosModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(inscritosModel, Inscritos.class);
	}


	@Override
	public InscritosModel transform(Inscritos inscritos) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(inscritos, InscritosModel.class);
	}


	@Override
	public List<Inscritos> listAllInscritosByAlumnoId(UsuariosModel usuario) {
		return inscritosRepository.findInscritosByIdAlumnoOrderByIdDesc(usuariosService.transform(usuario));
	}


	@Override
	public List<Inscritos> listAll() {
		return inscritosRepository.findAll();
	}


	@Override
	public List<Inscritos> listAllInscritosByIdOferta(OfertasModel oferta) {
		return inscritosRepository.findInscritosByIdOferta(ofertasService.transform(oferta));
	}


	@Override
	public List<Inscritos> findInscritosByIdAlumno(Usuarios idAlumno) {
		return inscritosRepository.findInscritosByIdAlumno(idAlumno);
	}


	@Override
	public List<Inscritos> findInscritosByIdOferta(Ofertas ofertas) {
		return inscritosRepository.findInscritosByIdOferta(ofertas);
	}


}

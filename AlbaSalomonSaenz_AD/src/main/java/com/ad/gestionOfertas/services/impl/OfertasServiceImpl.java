package com.ad.gestionOfertas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.models.OfertasModel;
import com.ad.gestionOfertas.models.UsuariosModel;
import com.ad.gestionOfertas.repositories.OfertasRepository;
import com.ad.gestionOfertas.services.OfertasService;
import com.ad.gestionOfertas.services.UsuariosService;

@Service
public class OfertasServiceImpl implements OfertasService {
	 
	@Autowired
	private OfertasRepository ofertasRepository;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Override
	public List<Ofertas> listAllOfertasByRrhh(UsuariosModel rrhh) {
		return ofertasRepository.findOfertasByRrhhid(usuariosService.transform(rrhh));
	}

	@Override
	public Ofertas transform(OfertasModel ofertasModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(ofertasModel, Ofertas.class);
	}

	@Override
	public OfertasModel transform(Ofertas ofertas) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(ofertas, OfertasModel.class);
	}



}

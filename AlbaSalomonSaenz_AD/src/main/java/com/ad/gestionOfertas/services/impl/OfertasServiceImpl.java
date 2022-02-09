package com.ad.gestionOfertas.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.models.CiclosModel;
import com.ad.gestionOfertas.models.OfertasModel;
import com.ad.gestionOfertas.models.UsuariosModel;
import com.ad.gestionOfertas.repositories.OfertasRepository;
import com.ad.gestionOfertas.services.CiclosService;
import com.ad.gestionOfertas.services.OfertasService;
import com.ad.gestionOfertas.services.UsuariosService;

@Service
public class OfertasServiceImpl implements OfertasService {
	 
	@Autowired
	private OfertasRepository ofertasRepository;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private CiclosService ciclosService;
	
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

	@Override
	public Ofertas createOferta(OfertasModel ofertasModel) {
		return ofertasRepository.save(transform(ofertasModel));
	}

	@Override
	public Ofertas findOfertaById(int id) {
		return ofertasRepository.findOfertaById(id);
	}

	@Override
	public void deleteOfertas(int id) {
		Ofertas oferta = ofertasRepository.findOfertaById(id);
		ofertasRepository.delete(oferta);
	}

	@Override
	public Ofertas updateOfertas(OfertasModel ofertasModel) {
		return ofertasRepository.save(transform(ofertasModel));
	}

	@Override
	public List<OfertasModel> listAllOfertas() {
		return ofertasRepository.findAll().stream().
				map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<Ofertas> listAll() {
		return ofertasRepository.findAll();
	}
	
	@Override
	public List<Ofertas> listAllOfertasByCicloId(CiclosModel ciclos) {
		return ofertasRepository.findOfertasByCicloId(ciclosService.transform(ciclos));
	}

}

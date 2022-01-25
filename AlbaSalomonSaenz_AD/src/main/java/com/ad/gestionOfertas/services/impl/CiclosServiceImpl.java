package com.ad.gestionOfertas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.models.CiclosModel;
import com.ad.gestionOfertas.repositories.CiclosRepository;
import com.ad.gestionOfertas.services.CiclosService;

@Service("ciclosServiceImpl")
public class CiclosServiceImpl implements CiclosService {
	
	@Autowired
	private CiclosRepository ciclosRepository;

	@Override
	public List<CiclosModel> listAllCiclos() {
		return ciclosRepository.findAll().stream().
				map(c->transform(c)).collect(Collectors.toList());
				
	}

	@Override
	public Ciclos transform(CiclosModel ciclosModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(ciclosModel, Ciclos.class);
	}

	@Override
	public CiclosModel transform(Ciclos ciclos) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(ciclos, CiclosModel.class);
	}

	@Override
	public Ciclos findCicloById(int id) {
		return ciclosRepository.findCicloById(id);
	}

	@Override
	public void deleteCiclos(int id) {
		Ciclos ciclo = ciclosRepository.findCicloById(id);
		ciclosRepository.delete(ciclo);
	}

	@Override
	public Ciclos updateCiclos(CiclosModel ciclosModel) {
		return ciclosRepository.save(transform(ciclosModel));
	}

	@Override
	public Ciclos createCiclo(CiclosModel ciclosModel) {
		return ciclosRepository.save(transform(ciclosModel));
	}


}

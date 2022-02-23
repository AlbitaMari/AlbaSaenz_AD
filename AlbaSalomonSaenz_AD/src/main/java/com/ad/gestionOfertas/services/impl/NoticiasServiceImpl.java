package com.ad.gestionOfertas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.entities.Noticias;
import com.ad.gestionOfertas.models.NoticiasModel;
import com.ad.gestionOfertas.repositories.NoticiasRepository;
import com.ad.gestionOfertas.services.NoticiasService;


@Service
public class NoticiasServiceImpl implements NoticiasService{
	
	@Autowired
	private NoticiasRepository noticiasRepository;
	
	
	@Override
	public Noticias transform(NoticiasModel noticiasModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(noticiasModel, Noticias.class);
	}

	@Override
	public NoticiasModel transform(Noticias noticias) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(noticias, NoticiasModel.class);
	}
	
	@Override
	public List<NoticiasModel> listAllNoticias() {
		return noticiasRepository.findAll().stream().
				map(c->transform(c)).collect(Collectors.toList());
	}
	
	@Override
	public Noticias createNoticia(NoticiasModel noticiasModel) {
		return noticiasRepository.save(transform(noticiasModel));
	}

	@Override
	public Noticias findNoticiasById(int id) {
		return noticiasRepository.findNoticiaById(id); 
	}

	@Override
	public void deleteNoticias(int id) {
		Noticias noticia = noticiasRepository.findNoticiaById(id);
		noticiasRepository.delete(noticia);
		
	}

	@Override
	public Noticias updateNoticias(NoticiasModel noticiasModel) {
		return noticiasRepository.save(transform(noticiasModel));
	}

	@Override
	public List<Noticias> findByCicloID(Ciclos cicloId) {
		return noticiasRepository.findNoticiaByCicloIdOrderByIdAsc(cicloId);
	}
}

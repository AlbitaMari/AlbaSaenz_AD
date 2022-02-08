package com.ad.gestionOfertas.services;

import java.util.List;

import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.entities.Noticias;
import com.ad.gestionOfertas.models.NoticiasModel;

public interface NoticiasService {
	List<NoticiasModel> listAllNoticias();
	Noticias transform(NoticiasModel noticiasModel);
	NoticiasModel transform(Noticias noticias);
	Noticias createNoticia(NoticiasModel noticiasModel);
	Noticias findNoticiasById(int id);
	public void deleteNoticias(int id);
	Noticias updateNoticias(NoticiasModel noticiasModel);
	List<Noticias> findByCicloID(Ciclos cicloId);
}

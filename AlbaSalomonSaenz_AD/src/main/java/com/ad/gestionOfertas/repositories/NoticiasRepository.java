package com.ad.gestionOfertas.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.entities.Noticias;

@Repository("noticiasRepository")
public interface NoticiasRepository  extends JpaRepository<Noticias,Serializable>{
		Noticias findNoticiaById(int id);
		public List<Noticias> findByCicloId(Ciclos ciclo);
}

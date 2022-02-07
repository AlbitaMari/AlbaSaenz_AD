package com.ad.gestionOfertas.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.entities.Usuarios;

@Repository("ofertasRepository")
public interface OfertasRepository  extends JpaRepository<Ofertas,Serializable>{
	
	public List<Ofertas> findOfertasByRrhhid(Usuarios rrhhid);
	Ofertas findOfertaById(int id);
	
}

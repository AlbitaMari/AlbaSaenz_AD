package com.ad.gestionOfertas.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.gestionOfertas.entities.Ofertas;

@Repository("ofertasRepository")
public interface OfertasRepository  extends JpaRepository<Ofertas,Serializable>{

}

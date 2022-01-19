package com.ad.gestionOfertas.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.gestionOfertas.entities.Noticias;

@Repository("noticiasRepository")
public interface NoticiasRepository  extends JpaRepository<Noticias,Serializable>{

}

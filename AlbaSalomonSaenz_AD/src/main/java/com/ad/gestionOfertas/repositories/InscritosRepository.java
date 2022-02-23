package com.ad.gestionOfertas.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.gestionOfertas.entities.Inscritos;
import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.entities.Usuarios;

@Repository
public interface InscritosRepository extends JpaRepository<Inscritos,Serializable> {

	public List<Inscritos> findInscritosByIdAlumnoOrderByIdDesc(Usuarios idAlumno);
	public List<Inscritos> findInscritosByIdAlumno(Usuarios idAlumno);
	public List<Inscritos> findInscritosByIdOferta(Ofertas idOferta);


}

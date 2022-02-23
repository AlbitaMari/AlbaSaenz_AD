package com.ad.gestionOfertas.services;

import java.util.List;

import com.ad.gestionOfertas.entities.Inscritos;
import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.models.InscritosModel;
import com.ad.gestionOfertas.models.OfertasModel;
import com.ad.gestionOfertas.models.UsuariosModel;


public interface InscritosService {
	
	Inscritos createInscrito(InscritosModel inscritosModel);
	Inscritos transform(InscritosModel inscritosModel);
	InscritosModel transform(Inscritos inscritos);
	List<Inscritos> listAllInscritosByAlumnoId(UsuariosModel usuario);
	List<Inscritos> listAllInscritosByIdOferta(OfertasModel oferta);
	List<Inscritos> listAll();
	List<Inscritos> findInscritosByIdAlumno(Usuarios idAlumno);
	List<Inscritos> findInscritosByIdOferta(Ofertas ofertas);
	
}

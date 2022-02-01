package com.ad.gestionOfertas.services;

import java.util.List;

import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.models.OfertasModel;
import com.ad.gestionOfertas.models.UsuariosModel;

public interface OfertasService {
	
	List<Ofertas> listAllOfertasByRrhh(UsuariosModel rrhh);
	Ofertas transform(OfertasModel ofertasModel);
	OfertasModel transform(Ofertas ofertas);
	
}

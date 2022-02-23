package com.ad.gestionOfertas.services;

import java.util.List;

import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.models.CiclosModel;
import com.ad.gestionOfertas.models.OfertasModel;
import com.ad.gestionOfertas.models.UsuariosModel;

public interface OfertasService {
	
	List<Ofertas> listAllOfertasByRrhh(UsuariosModel rrhh);
	Ofertas transform(OfertasModel ofertasModel);
	OfertasModel transform(Ofertas ofertas);
	Ofertas createOferta(OfertasModel ofertasModel);
	Ofertas findOfertaById(int id);
	public void deleteOfertas(int id);
	Ofertas updateOfertas(OfertasModel ofertasModel);
	List<OfertasModel> listAllOfertas();
	List<Ofertas> listAll();
	List<Ofertas> listAllOfertasByCicloId(CiclosModel ciclo);
	List<Ofertas> findOfertaByCicloId(Ciclos ciclo);
	
}

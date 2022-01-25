package com.ad.gestionOfertas.services;

import java.util.List;

import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.models.CiclosModel;

public interface CiclosService {
	
	List<CiclosModel> listAllCiclos();
	Ciclos transform(CiclosModel ciclosModel);
	CiclosModel transform(Ciclos ciclos);
	Ciclos findCicloById(int id);
	public void deleteCiclos(int id);
	Ciclos updateCiclos(CiclosModel ciclosModel);
	Ciclos createCiclo(CiclosModel ciclosModel);
}

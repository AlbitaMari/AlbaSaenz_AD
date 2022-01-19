package com.ad.gestionOfertas.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.gestionOfertas.entities.Ciclos;

@Repository("ciclosRepository")
public interface CiclosRepository extends JpaRepository<Ciclos,Serializable> {

}

package com.devsystempro.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsystempro.dsclient.entities.Client;

//Camada de Acesso a Dados

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	

}

package com.devsystempro.dsclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsystempro.dsclient.entities.Client;
import com.devsystempro.dsclient.repositories.ClientRepository;

@Service  //essa annotation ela vai registrar a classe como o componente que vai participar do sistema de injeção de dependecias automatizado do spring (gerente que vai registrartudo relacionado a ClientService) 
public class ClientService {
    
	@Autowired 
	private ClientRepository repository;//objeto injetado e instanciado..
	
	@Transactional(readOnly=true)//garante uma transação com o banco sem travar a operação dando lock 
	public List<Client>findAll(){	
	return repository.findAll();	
	}
}

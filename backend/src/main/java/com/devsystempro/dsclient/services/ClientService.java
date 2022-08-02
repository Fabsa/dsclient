package com.devsystempro.dsclient.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsystempro.dsclient.dto.ClientDTO;
import com.devsystempro.dsclient.entities.Client;
import com.devsystempro.dsclient.repositories.ClientRepository;

@Service  //essa annotation ela vai registrar a classe como o componente que vai participar do sistema de injeção de dependecias automatizado do spring (gerente que vai registrartudo relacionado a ClientService) 
public class ClientService {
    
	@Autowired 
	private ClientRepository repository;//objeto injetado e instanciado..
	
	@Transactional(readOnly=true)//garante uma transação com o banco sem travar a operação dando lock 
	public List<ClientDTO>findAll(){	
	      List<Client>list = repository.findAll();		      
	      //conversão de forma resumida
	      return list.stream().map(x->new ClientDTO(x)).collect(Collectors.toList()); //pega cada elemento da lista Client e transforma em uma list DTO usando expressao lambda.
	      
	  
	}
}


/* uma forma aceitavel
 * 
 *  List<ClientDTO>listDto=new ArrayList<>();
 *  for(Client cat:list) {//percorre a lista e converte uma list de client para uma list do tipo DTO
	    	  listDto.add(new ClientDTO(cat));
	      }
	     return listDto;
 * */
 
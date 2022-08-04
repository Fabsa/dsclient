package com.devsystempro.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;//usado no metodo delete no tratamento de exclusão de itens do banco vendo a integridade
import org.springframework.dao.EmptyResultDataAccessException;//usado no metodo delete no tratamento de exclusão de itens do banco vendo verifica se o itens tem relacionamento com outro item 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsystempro.dsclient.dto.ClientDTO;
import com.devsystempro.dsclient.entities.Client;
import com.devsystempro.dsclient.repositories.ClientRepository;
import com.devsystempro.dsclient.services.exceptions.DatabaseException;
import com.devsystempro.dsclient.services.exceptions.ResourceNotFoundException;

@Service  //essa annotation ela vai registrar a classe como o componente que vai participar do sistema de injeção de dependecias automatizado do spring (gerente que vai registrartudo relacionado a ClientService) 
public class ClientService {
    
	@Autowired 
	private ClientRepository repository;//objeto injetado e instanciado..
	
	@Transactional(readOnly=true)//garante uma transação com o banco sem travar a operação dando lock 
	public List<ClientDTO>findAll()
	 {	
	      List<Client>list = repository.findAll();		      
	      //conversão de forma resumida
	      return list.stream().map(x ->new ClientDTO(x)).collect(Collectors.toList()); //pega cada elemento da lista Client e transforma em uma list DTO usando expressao lambda.
	 }
	      @Transactional(readOnly=true)//garante uma transação com o banco sem travar a operação dando lock 
	  	public ClientDTO findById(Long id)
	       {	
	  	      Optional<Client>obj = repository.findById(id);
	  	      Client entity = obj.orElseThrow(()->new ResourceNotFoundException("Entity not found"));//optional verifica se exite o objeto, se caso não exista ele lança a exceção tratada.
	  	      //conversão de forma resumida
	  	      return new ClientDTO(entity); //pega cada elemento da lista Client e transforma em uma list DTO usando expressao lambda.
	       }
	      
	      @Transactional
	      public ClientDTO insert(ClientDTO dto)
	      {
			Client entity = new Client();
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity = repository.save(entity);
			
			return new ClientDTO(entity);  			
		  }
	      
	      @Transactional
		  public ClientDTO update(Long id, ClientDTO dto) {
			try 
			{
		    	Client entity = repository.getOne(id);
				entity.setName(dto.getName());
				entity.setCpf(dto.getCpf());
				entity.setIncome(dto.getIncome());
				entity.setBirthDate(dto.getBirthDate());
				entity.setChildren(dto.getChildren());
				entity = repository.save(entity);
				
				return new ClientDTO(entity);
				
			}catch(EntityNotFoundException e) {
				throw new ResourceNotFoundException("Id not Fount "+ id);
			}							
		}
	     //não usa transactional 
		public void delete(Long id) {
			try{
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException("Id not found " +id);
			}
			catch(DataIntegrityViolationException e) {
				throw new DatabaseException("Integrity violetion");
			}
			
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
 
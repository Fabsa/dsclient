package com.devsystempro.dsclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsystempro.dsclient.dto.ClientDTO;
import com.devsystempro.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {//implementação do controlador REST onde as APIs serao implementadas atraves do controlador rest

	@Autowired
    private ClientService service;
	@GetMapping	
	public ResponseEntity<List<ClientDTO>>findAll(){ //muda de Client para ClientDTO
	List<ClientDTO>list = service.findAll();
	return ResponseEntity.ok().body(list);
   }
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO>findById(@PathVariable Long id){ //muda de Client para ClientDTO
	ClientDTO dto = service.findById(id);
	return ResponseEntity.ok().body(dto);
   }
}

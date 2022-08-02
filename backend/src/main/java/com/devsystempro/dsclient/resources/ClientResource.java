package com.devsystempro.dsclient.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsystempro.dsclient.entities.Client;
import com.devsystempro.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {//implementação do controlador REST onde as APIs serao implementadas atraves do controlador rest

	@Autowired
    private ClientService service;
	@GetMapping	
	public ResponseEntity<List<Client>>findAll(){
	List<Client>list = service.findAll();
	return ResponseEntity.ok().body(list);
   }
}
/*list.add(new Client(1L,"Maria Silvaaa","12345678901",6500.0,Instant.parse("1994-07-20T10:30:00Z"),2));
list.add(new Client(1L,"Antonio Carlos","30401220112",6500.0,Instant.parse("1994-07-20T10:30:00Z"),3));*/
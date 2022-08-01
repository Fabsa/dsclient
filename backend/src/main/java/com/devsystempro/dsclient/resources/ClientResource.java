package com.devsystempro.dsclient.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsystempro.dsclient.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {//implementação do controlador REST onde as APIs serao implementadas atraves do controlador rest


	@GetMapping	
	public ResponseEntity<List<Client>>findAll(){
	List<Client>list = new ArrayList<>();
	list.add(new Client(1L,"Maria Silvaaa","12345678901",6500.0,Instant.parse("1994-07-20T10:30:00Z"),2));
	list.add(new Client(1L,"Antonio Carlos","30401220112",6500.0,Instant.parse("1994-07-20T10:30:00Z"),3));
     return ResponseEntity.ok().body(list);
   }
}

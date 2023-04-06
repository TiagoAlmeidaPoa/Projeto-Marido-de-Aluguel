package com.tiago.maridodealuguel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.maridodealuguel.dtos.ClienteDTO;
import com.tiago.maridodealuguel.service.ClienteService;

@RestController
@RequestMapping( value = "/clientes" )
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
		ClienteDTO obj = new ClienteDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<ClienteDTO> dtos = service.findAll();
		return ResponseEntity.ok().body(dtos);
	}
	
}

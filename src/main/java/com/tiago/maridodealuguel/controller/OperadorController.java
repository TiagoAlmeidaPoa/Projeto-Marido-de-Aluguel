package com.tiago.maridodealuguel.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiago.maridodealuguel.domain.Operador;
import com.tiago.maridodealuguel.dtos.OperadorDTO;
import com.tiago.maridodealuguel.service.OperadorService;

@RestController
@RequestMapping(value = "/operadores")
public class OperadorController {
	
	@Autowired
	private OperadorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OperadorDTO> findById(@PathVariable Integer id){
		OperadorDTO operadorDTO = new OperadorDTO(service.findById(id));
		return ResponseEntity.ok().body(operadorDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<OperadorDTO>> findAll(){		
		List<OperadorDTO> dtos = service.findAll().stream().map(op -> new OperadorDTO(op)).collect(Collectors.toList());				
		return ResponseEntity.ok().body(dtos);
	}
	
	@PostMapping
	public ResponseEntity<OperadorDTO> create(@RequestBody OperadorDTO operadorDTO) {
		Operador operador = service.create(operadorDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(operador.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

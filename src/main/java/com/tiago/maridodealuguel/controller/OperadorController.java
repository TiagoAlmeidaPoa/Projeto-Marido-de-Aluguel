package com.tiago.maridodealuguel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.maridodealuguel.domain.Operador;
import com.tiago.maridodealuguel.service.OperadorService;

@RestController
@RequestMapping(value = "/operadores")
public class OperadorController {
	
	@Autowired
	private OperadorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Operador> findById(@PathVariable Integer id){
		Operador operador = service.findById(id);
		return ResponseEntity.ok().body(operador);
	}

}

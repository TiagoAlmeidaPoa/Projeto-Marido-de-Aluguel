package com.tiago.maridodealuguel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.maridodealuguel.dtos.OSDTO;
import com.tiago.maridodealuguel.service.OSService;

@RestController
@RequestMapping(value = "/ordens")
public class OSController {
	
	@Autowired
	private OSService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OSDTO> findById(@PathVariable Integer id){
		OSDTO dto = new OSDTO(service.findById(id));
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<OSDTO>> findAll(){
		List<OSDTO> listaDTO = service.findAll();
		return ResponseEntity.ok(listaDTO);
	}	
	
}

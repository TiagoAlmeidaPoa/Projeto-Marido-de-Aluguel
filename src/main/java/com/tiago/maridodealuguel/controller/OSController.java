package com.tiago.maridodealuguel.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiago.maridodealuguel.dtos.OSDTO;
import com.tiago.maridodealuguel.service.OSService;

@RestController
@RequestMapping(value = "/ordens")
public class OSController {

	@Autowired
	private OSService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<OSDTO> findById(@PathVariable Integer id) {
		OSDTO dto = new OSDTO(service.findById(id));
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	public ResponseEntity<List<OSDTO>> findAll() {
		List<OSDTO> listaDTO = service.findAll();
		return ResponseEntity.ok(listaDTO);
	}

	@PostMapping
	public ResponseEntity<OSDTO> create(@Valid @RequestBody OSDTO dto) {
		dto = new OSDTO(service.create(dto));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<OSDTO> update(@Valid @RequestBody OSDTO dto) {
		dto = new OSDTO(service.update(dto));
		return ResponseEntity.ok(dto);
	}

}

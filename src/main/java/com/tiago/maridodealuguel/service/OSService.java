package com.tiago.maridodealuguel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.maridodealuguel.domain.OS;
import com.tiago.maridodealuguel.dtos.OSDTO;
import com.tiago.maridodealuguel.repositories.OSRepository;
import com.tiago.maridodealuguel.service.exceptions.ObjectNotFoundException;

@Service
public class OSService {
	
	@Autowired
	private OSRepository repository;
	
	public OS findById(Integer id) {
			Optional<OS> obj = repository.findById(id);
			return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + OS.class.getName()) );
	}

	public List<OSDTO> findAll() {		
		return repository.findAll().stream().map(x -> new OSDTO(x)).toList();
	}

}

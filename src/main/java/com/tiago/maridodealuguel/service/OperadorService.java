package com.tiago.maridodealuguel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.maridodealuguel.domain.Operador;
import com.tiago.maridodealuguel.repositories.OperadorRepository;

@Service
public class OperadorService {
	
	@Autowired
	private OperadorRepository repository;
	
	public Operador findById(Integer id) {
		Optional<Operador> operador = repository.findById(id);
		return operador.orElse(null);
	}

}

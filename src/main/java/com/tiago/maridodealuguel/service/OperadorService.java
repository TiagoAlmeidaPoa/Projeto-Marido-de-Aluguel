package com.tiago.maridodealuguel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.maridodealuguel.domain.Operador;
import com.tiago.maridodealuguel.dtos.OperadorDTO;
import com.tiago.maridodealuguel.repositories.OperadorRepository;
import com.tiago.maridodealuguel.service.exceptions.ObjectNotFoundException;

@Service
public class OperadorService {

	@Autowired
	private OperadorRepository repository;

	public Operador findById(Integer id) {
		Optional<Operador> operador = repository.findById(id);
		return operador.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! " + id + ", Tipo: " + Operador.class.getName()));
	}

	public List<Operador> findAll() {
		return repository.findAll();
	}

	public Operador create(OperadorDTO operadorDTO) {
		if(findByCPF(operadorDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Operador(null, operadorDTO.getNome(), operadorDTO.getCpf(), operadorDTO.getTelefone()));
		
	}
	
	public Operador findByCPF(OperadorDTO objDTO) {
		Operador obj = repository.findByCPF(objDTO.getCpf());
		return (obj != null) ? obj : null;
	}

}

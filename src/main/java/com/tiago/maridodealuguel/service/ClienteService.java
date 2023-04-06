package com.tiago.maridodealuguel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.maridodealuguel.domain.Cliente;
import com.tiago.maridodealuguel.dtos.ClienteDTO;
import com.tiago.maridodealuguel.repositories.ClienteRepository;
import com.tiago.maridodealuguel.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				" Objeto não encontrado ! " + id + " Tipo: " + Cliente.class.getName()
				));
	}

	public List<ClienteDTO> findAll() {
		List<ClienteDTO> dtos = repository.findAll().stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
		return dtos;
	}
	

}

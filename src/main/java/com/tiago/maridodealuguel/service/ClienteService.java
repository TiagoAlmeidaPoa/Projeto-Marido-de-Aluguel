package com.tiago.maridodealuguel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.maridodealuguel.domain.Cliente;
import com.tiago.maridodealuguel.domain.Pessoa;
import com.tiago.maridodealuguel.dtos.ClienteDTO;
import com.tiago.maridodealuguel.repositories.ClienteRepository;
import com.tiago.maridodealuguel.repositories.PessoaRepository;
import com.tiago.maridodealuguel.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
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

	public Cliente create(ClienteDTO clienteDTO) {
		if(findByCPF(clienteDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Cliente(null, clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getTelefone()));
	}
	
	public Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		return (obj != null) ? obj : null;
	}
	
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente cliente = findById(id);
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		cliente.setCpf(objDTO.getCpf());
		cliente.setName(objDTO.getNome());
		cliente.setTelefone(objDTO.getTelefone());
		
		return repository.save(cliente);
	}
	
	public void delete(Integer id) {
		Cliente cliente = findById(id);
		if(cliente.getListaOS().size() > 0) {
			throw new DataIntegratyViolationException("Cliente possui ordens de serviço, não pode ser deletado!");
		}
		repository.deleteById(cliente.getId());
	}

}

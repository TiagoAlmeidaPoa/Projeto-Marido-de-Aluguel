package com.tiago.maridodealuguel.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.maridodealuguel.domain.Operador;
import com.tiago.maridodealuguel.domain.Pessoa;
import com.tiago.maridodealuguel.dtos.OperadorDTO;
import com.tiago.maridodealuguel.repositories.OperadorRepository;
import com.tiago.maridodealuguel.repositories.PessoaRepository;
import com.tiago.maridodealuguel.service.exceptions.ObjectNotFoundException;

@Service
public class OperadorService {

	@Autowired
	private OperadorRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Operador findById(Integer id) {
		Optional<Operador> operador = repository.findById(id);
		return operador.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! " + id + ", Tipo: " + Operador.class.getName()));
	}

	public List<Operador> findAll() {
		return repository.findAll();
	}

	public Operador create(OperadorDTO operadorDTO) {
		if (findByCPF(operadorDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository
				.save(new Operador(null, operadorDTO.getNome(), operadorDTO.getCpf(), operadorDTO.getTelefone()));

	}

	public Operador update(Integer id, @Valid OperadorDTO objDTO) {
		Operador oldObj = findById(id);

		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		oldObj.setCpf(objDTO.getCpf());
		oldObj.setName(objDTO.getNome());
		oldObj.setTelefone(objDTO.getTelefone());

		return repository.save(oldObj);
	}

	public Pessoa findByCPF(OperadorDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		return (obj != null) ? obj : null;
	}

	public void delete(Integer id) {
		Operador obj = findById(id);
		if(obj.getListaOS().size() > 0) {
			throw new DataIntegratyViolationException("Operador possui ordens de serviço, não pode ser deletado!");
		}
		repository.deleteById(obj.getId());
	}

}

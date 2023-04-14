package com.tiago.maridodealuguel.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.maridodealuguel.domain.Cliente;
import com.tiago.maridodealuguel.domain.OS;
import com.tiago.maridodealuguel.domain.Operador;
import com.tiago.maridodealuguel.domain.enums.Prioridade;
import com.tiago.maridodealuguel.domain.enums.Status;
import com.tiago.maridodealuguel.dtos.OSDTO;
import com.tiago.maridodealuguel.repositories.OSRepository;
import com.tiago.maridodealuguel.service.exceptions.ObjectNotFoundException;

@Service
public class OSService {

	@Autowired
	private OSRepository repository;

	@Autowired
	private OperadorService operadorService;

	@Autowired
	private ClienteService clienteService;

	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + OS.class.getName()));
	}

	public List<OSDTO> findAll() {
		return repository.findAll().stream().map(x -> new OSDTO(x)).toList();
	}

	public OS create(@Valid OSDTO dto) {
		OS os = fromDTO(dto);
		return repository.save(os);
	}
	
	public OS update(@Valid OSDTO dto) {
		findById(dto.getId());
		return repository.save(fromDTO(dto));
	}

	private OS fromDTO(OSDTO dto) {
		OS os = new OS();
		os.setId(dto.getId());
		os.setObservacoes(dto.getObservacoes());
		os.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
		os.setStatus(Status.toEnum(dto.getStatus()));
		os.setPreco(dto.getPreco());

		Operador oper = operadorService.findById(dto.getOperador());
		Cliente cli = clienteService.findById(dto.getCliente());

		os.setOperador(oper);
		os.setCliente(cli);
		
		if(os.getStatus().getCod().equals(2)) {
			os.setDataFechamento(LocalDateTime.now());
		}

		return os;
	}

}

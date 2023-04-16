package com.tiago.maridodealuguel.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.maridodealuguel.domain.Cliente;
import com.tiago.maridodealuguel.domain.OS;
import com.tiago.maridodealuguel.domain.Operador;
import com.tiago.maridodealuguel.domain.enums.Prioridade;
import com.tiago.maridodealuguel.domain.enums.Status;
import com.tiago.maridodealuguel.repositories.ClienteRepository;
import com.tiago.maridodealuguel.repositories.OSRepository;
import com.tiago.maridodealuguel.repositories.OperadorRepository;

@Service
public class DBService {

	@Autowired
	private OperadorRepository operadorRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Operador op1 = new Operador(null, "Jober Treim Filho", "09162216015", "5198745869");
		Operador op2 = new Operador(null, "Josuar Crismer", "10769153020", "5198745465");
		Operador op3 = new Operador(null, "Valesca popozuda", "32560413027", "5188715487");
		Cliente cli1 = new Cliente(null, "Fred Gusmao", "69561809010", "4986963625");
		OS os1 = new OS(null, Prioridade.ALTA, Status.ABERTO, "Testando ordem de servico", op1, cli1, 80.00);
		OS os2 = new OS(null, Prioridade.ALTA, Status.ABERTO, "Terraplanagem 200 metros", op1, cli1, 1200.00);

		op1.getListaOS().addAll(Arrays.asList(os1, os2));
		cli1.getListaOS().addAll(Arrays.asList(os1, os2));

		operadorRepository.saveAll(Arrays.asList(op1, op2, op3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		osRepository.saveAll(Arrays.asList(os1, os2));
	}

}

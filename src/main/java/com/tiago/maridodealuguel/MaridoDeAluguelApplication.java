package com.tiago.maridodealuguel;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiago.maridodealuguel.domain.Cliente;
import com.tiago.maridodealuguel.domain.OS;
import com.tiago.maridodealuguel.domain.Operador;
import com.tiago.maridodealuguel.domain.enums.Prioridade;
import com.tiago.maridodealuguel.domain.enums.Status;
import com.tiago.maridodealuguel.repositories.ClienteRepository;
import com.tiago.maridodealuguel.repositories.OSRepository;
import com.tiago.maridodealuguel.repositories.OperadorRepository;

@SpringBootApplication
public class MaridoDeAluguelApplication implements CommandLineRunner {

	@Autowired
	private OperadorRepository operadorRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public static void main(String[] args) {
		SpringApplication.run(MaridoDeAluguelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Operador op1 = new Operador(null, "Jober Treim Filho", "09162216015", "5198745869");
		Cliente cli1 = new Cliente(null, "Fred Gusmao", "69561809010", "4986963625");
		OS os1 = new OS(null, Prioridade.ALTA, Status.ABERTO, "Testando ordem de servico", op1, cli1, 80.00);
		
		op1.getListaOS().add(os1);
		cli1.getListaOS().add(os1);		

		operadorRepository.saveAll(Arrays.asList(op1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		osRepository.saveAll(Arrays.asList(os1));

	}

}

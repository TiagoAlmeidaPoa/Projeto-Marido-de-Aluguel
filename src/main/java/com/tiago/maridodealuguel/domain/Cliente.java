package com.tiago.maridodealuguel.domain;

public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String name, String cpf, String telefone) {
		super(id, name, cpf, telefone);
	}

}

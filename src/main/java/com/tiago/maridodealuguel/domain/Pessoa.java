package com.tiago.maridodealuguel.domain;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String cpf;
	private String telefone;

	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String name, String cpf, String telefone) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}

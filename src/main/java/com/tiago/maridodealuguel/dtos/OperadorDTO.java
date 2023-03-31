package com.tiago.maridodealuguel.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.tiago.maridodealuguel.domain.Operador;

public class OperadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	@CPF
	private String cpf;
	private String telefone;

	public OperadorDTO() {
		super();
	}

	public OperadorDTO(Operador operador) {
		this.id = operador.getId();
		this.nome = operador.getName();
		this.cpf = operador.getCpf();
		this.telefone = operador.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

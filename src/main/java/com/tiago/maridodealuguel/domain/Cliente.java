package com.tiago.maridodealuguel.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<OS> listaOS = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

	public List<OS> getListaOS() {
		return listaOS;
	}

	public void setListaOS(List<OS> listaOS) {
		this.listaOS = listaOS;
	}

}

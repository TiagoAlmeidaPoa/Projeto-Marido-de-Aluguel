package com.tiago.maridodealuguel.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Operador extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "operador")
	@JsonIgnore
	private List<OS> listaOS = new ArrayList<>();

	public Operador() {
		super();
	}

	public Operador(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

	public List<OS> getListaOS() {
		return listaOS;
	}

	public void setListaOS(List<OS> listaOS) {
		this.listaOS = listaOS;
	}

}

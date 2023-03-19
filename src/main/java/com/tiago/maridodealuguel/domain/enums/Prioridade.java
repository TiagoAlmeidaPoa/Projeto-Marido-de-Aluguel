package com.tiago.maridodealuguel.domain.enums;

public enum Prioridade {

	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

	private Integer cod;
	private String descricao;

	private Prioridade(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Prioridade toEnum(Integer cod) {
		if (cod == null)
			return null;

		for (Prioridade prioridade : Prioridade.values()) {
			if (cod.equals(prioridade.getCod()))
				return prioridade;
		}

		throw new IllegalArgumentException("O codigo de prioridade " + cod + " é inválido !");
	}

}

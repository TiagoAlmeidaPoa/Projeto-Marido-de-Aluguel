package com.tiago.maridodealuguel.domain.enums;

public enum Status {
	
	ABERTO(0,"ABERTO"),
	FECHADO(0,"FECHADO"),
	ANDAMENTO(2,"ANDAMENTO");
	
	private Integer cod;
	private String descricao;
	
	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		
		if(cod == null) return null;
		
		for(Status status : Status.values()) {
			if(cod.equals(status.getCod())) return status;
		}
		
		throw new IllegalArgumentException("O codigo de Status "+cod+" é inválido !");
	}

}

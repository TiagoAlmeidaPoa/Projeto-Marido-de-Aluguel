package com.tiago.maridodealuguel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tiago.maridodealuguel.domain.Operador;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Integer> {
	
	@Query("SELECT obj FROM Operador obj WHERE obj.cpf =:cpf")
	Operador findByCPF(@Param("cpf") String cpf);
	
}

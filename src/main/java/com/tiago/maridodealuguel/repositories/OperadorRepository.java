package com.tiago.maridodealuguel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.maridodealuguel.domain.Operador;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Integer> {

}

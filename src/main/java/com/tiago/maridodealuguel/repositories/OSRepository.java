package com.tiago.maridodealuguel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.maridodealuguel.domain.OS;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer> {

}

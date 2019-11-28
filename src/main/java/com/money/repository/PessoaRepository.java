package com.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.money.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}

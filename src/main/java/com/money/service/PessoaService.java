package com.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.exception.PessoaNaoEncontradaException;
import com.money.model.Pessoa;
import com.money.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listAll(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa getById(Long id) {
		return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException());
	}
	
}

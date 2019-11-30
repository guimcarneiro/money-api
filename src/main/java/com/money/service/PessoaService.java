package com.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.exception.PessoaInexistenteOuInativaException;
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
		return pessoaRepository.findById(id).orElseThrow(() -> new PessoaInexistenteOuInativaException());
	}
	
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	//Conferir se a categoria é a mesma do que já está cadastrada
	public Pessoa update(Long id, Pessoa pessoaAtualizada) {
		Optional<Pessoa> pessoaExistente = pessoaRepository.findById(id);
		
		if(!pessoaExistente.isPresent()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		Pessoa pessoaSalva = pessoaExistente.get();
		
		BeanUtils.copyProperties(pessoaAtualizada, pessoaSalva, "codigo");
		pessoaRepository.save(pessoaSalva);
		
		return pessoaSalva;
	}
	
	
	public void deleteById(Long id){
		Optional<Pessoa> categoriaExistente = pessoaRepository.findById(id);
		
		if(!categoriaExistente.isPresent())
			throw new PessoaInexistenteOuInativaException();
		
		pessoaRepository.deleteById(id);
	} 
	
}

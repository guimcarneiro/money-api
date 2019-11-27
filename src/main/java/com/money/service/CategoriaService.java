package com.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.model.Categoria;
import com.money.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	//TODO: corrigir comparação entre o id passado e o id da categoria passada no body
	public Optional<Categoria> update(Long id, Categoria categoria) {
		Optional<Categoria> c = categoriaRepository.findById(id);
		
		if(c.isPresent()) {
			categoriaRepository.save(categoria);
			return c;
		}
		
		return Optional.empty();
	}
	
	public Optional<Categoria> getById(long id) {
		Optional<Categoria> c = categoriaRepository.findById(id);
		return c;
	}
	
	public Optional<Categoria> deleteById(long id){
		Optional<Categoria> c = categoriaRepository.findById(id);
		
		if(c.isPresent())
			categoriaRepository.deleteById(id);
		
		return c;
	}
}

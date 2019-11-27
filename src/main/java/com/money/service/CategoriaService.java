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
	
	public Optional<Categoria> update(long id, Categoria categoria) {
		Optional<Categoria> c = categoriaRepository.findById(id);
		
		if(c.isPresent()) {
			if(c.get().getCodigo() == categoria.getCodigo())
				categoriaRepository.save(categoria);
			else
				return Optional.empty();
		}
		
		return c;
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

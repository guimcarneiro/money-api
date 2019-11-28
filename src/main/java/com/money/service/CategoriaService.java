package com.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.exception.CategoriaNaoEncontradaException;
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

	//Conferir se a categoria é a mesma do que já está cadastrada
	public Categoria update(Long id, Categoria categoriaAtualizada) {
		Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
		
		if(!categoriaExistente.isPresent()) {
			throw new CategoriaNaoEncontradaException();
		}
		
		Categoria categoriaSalva = categoriaExistente.get();
		
		BeanUtils.copyProperties(categoriaAtualizada, categoriaSalva, "codigo");
		categoriaRepository.save(categoriaSalva);
		
		return categoriaSalva;
	}
	
	public Categoria getById(Long id) {
		Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
		
		if(!categoriaExistente.isPresent())
			throw new CategoriaNaoEncontradaException();
		
		Categoria categoriaRetornada = categoriaExistente.get();
		return categoriaRetornada;
	}
	
	public void deleteById(Long id){
		Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
		
		if(!categoriaExistente.isPresent())
			throw new CategoriaNaoEncontradaException();
		
		categoriaRepository.deleteById(id);
	}
}

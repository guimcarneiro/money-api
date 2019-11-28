package com.money.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.model.Categoria;
import com.money.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listAll(){
		return categoriaService.listAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaService.save(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
		Categoria categoriaRetornada = categoriaService.update(id, categoria);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRetornada);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable("id") Long id){
		Categoria categoriaRetornada = categoriaService.getById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRetornada);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> deleteById(@PathVariable Long id){
		categoriaService.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}

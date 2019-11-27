package com.money.resource;

import java.util.List;
import java.util.Optional;

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
	public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
		Categoria c = categoriaService.save(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable long id, @RequestBody Categoria categoria){
		Optional<Categoria> c = categoriaService.update(id, categoria);
		
		if(c.isPresent())
			return ResponseEntity.status(HttpStatus.CREATED).body(c.get());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") long id){
		Optional<Categoria> c = categoriaService.getById(id);
		if(c.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(c.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Categoria> deleteCategoriaById(@PathVariable("id") long id){
		Optional<Categoria> c = categoriaService.deleteById(id);
		
		if(c.isPresent())
			return ResponseEntity.status(HttpStatus.OK).build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}

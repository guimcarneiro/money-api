package com.money.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.model.Pessoa;
import com.money.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listAll(){
		List<Pessoa> pessoas = pessoaService.listAll();
		return pessoas.isEmpty()? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(pessoas);
	}

	@GetMapping("{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Long id){
		Pessoa pessoaRetornada = pessoaService.getById(id);
		return pessoaRetornada == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(pessoaRetornada);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa novaPessoa){
		Pessoa pessoaSalva = pessoaService.save(novaPessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Pessoa> deleteById(@PathVariable Long id){
		pessoaService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}

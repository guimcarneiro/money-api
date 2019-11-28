package com.money.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Pessoa> listAll(){
		return pessoaService.listAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Long id){
		Pessoa pessoaRetornada = pessoaService.getById(id);
		return pessoaRetornada == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(pessoaRetornada);
	}
	
}

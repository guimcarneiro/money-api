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

import com.money.model.Lancamento;
import com.money.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;
	
	@GetMapping
	public ResponseEntity<List<Lancamento>> listAll(){
		List<Lancamento> lancamentos = lancamentoService.listAll();
		return lancamentos.isEmpty()? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(lancamentos);
	}

	@GetMapping("{id}")
	public ResponseEntity<Lancamento> getById(@PathVariable Long id){
		Lancamento lancamentoRetornada = lancamentoService.getById(id);
		return lancamentoRetornada == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(lancamentoRetornada);
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> save(@RequestBody Lancamento novolancamento){
		Lancamento lancamentoSalvo = lancamentoService.save(novolancamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Lancamento> deleteById(@PathVariable Long id){
		lancamentoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}

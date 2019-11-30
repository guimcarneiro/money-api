package com.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.exception.LancamentoInexistenteException;
import com.money.model.Lancamento;
import com.money.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public List<Lancamento> listAll(){
		return lancamentoRepository.findAll();
	}
	
	public Lancamento getById(Long id) {
		return lancamentoRepository.findById(id).orElseThrow(() -> new LancamentoInexistenteException());
	}
	
	public Lancamento save(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

	public Lancamento update(Long id, Lancamento lancamentoAtualizada) {
		Optional<Lancamento> lancamentoExistente = lancamentoRepository.findById(id);
		
		if(!lancamentoExistente.isPresent()) {
			throw new LancamentoInexistenteException();
		}
		
		Lancamento lancamentoSalvo = lancamentoExistente.get();
		
		BeanUtils.copyProperties(lancamentoAtualizada, lancamentoSalvo, "codigo");
		lancamentoRepository.save(lancamentoSalvo);
		
		return lancamentoSalvo;
	}
	
	public void deleteById(Long id){
		Optional<Lancamento> categoriaExistente = lancamentoRepository.findById(id);
		
		if(!categoriaExistente.isPresent())
			throw new LancamentoInexistenteException();
		
		lancamentoRepository.deleteById(id);
	} 
	
	
}

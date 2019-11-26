package com.money.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	private Long codigo;
	
	private String nome;

	/**
	 * @return the id
	 */
	public Long getId() {
		return codigo;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}



}

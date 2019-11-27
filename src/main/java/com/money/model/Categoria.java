package com.money.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3505985952291451921L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank
	private String nome;

	/**
	 * @return the id
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param id the id to set
	 */
	public void setCodigo(Long codigo) {
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Categoria c = (Categoria) obj;
		if(this.codigo.equals(c.codigo))
			return true;
		
		return false;
	}

}

package br.com.arptec.acesso.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcao {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_funcao;
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id_funcao;
	}

}

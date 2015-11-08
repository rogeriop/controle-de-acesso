package br.com.arptec.acesso.modelo;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="grupo")
public class Grupo {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_grupo;
	private String nome;

	@OneToMany(mappedBy="grupo")
	private List<Usuario> usuarios;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
	@JoinTable(
			name="grupo_funcao",
			joinColumns = @JoinColumn(name="id_grupo"), inverseJoinColumns = @JoinColumn(name = "id_funcao"))
	private Collection<Funcao> funcoes;

	public Long getId() {
		return id_grupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Collection<Funcao> getFuncoes() {
		return funcoes;
	}
	
	public void setFuncoes(Collection<Funcao> funcoes) {
		this.funcoes = funcoes;
		
	}
	
}

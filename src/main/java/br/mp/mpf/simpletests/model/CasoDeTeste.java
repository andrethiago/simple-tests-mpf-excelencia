package br.mp.mpf.simpletests.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CASO_DE_TESTE")
public class CasoDeTeste {

	@Id
	@Column(name = "ID_CASO_DE_TESTE", nullable = false, unique = true)
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	private Usuario testador;

	private TipoTeste tipo;

	private Set<Historia> historias;

	// passos ???

}

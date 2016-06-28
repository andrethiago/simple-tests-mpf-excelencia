package br.mp.mpf.simpletests.model;

import java.util.Date;
import java.util.Set;

public class PlanoDeTeste {

	private Long id;

	private Projeto projeto;

	private String nome; // ex: RELEASE 01, SPRINT 02

	private Date dataInicial;

	private Date dataFinal;

	private String descricao;

	private Set<Historia> escopo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Historia> getEscopo() {
		return escopo;
	}

	public void setEscopo(Set<Historia> escopo) {
		this.escopo = escopo;
	}

}

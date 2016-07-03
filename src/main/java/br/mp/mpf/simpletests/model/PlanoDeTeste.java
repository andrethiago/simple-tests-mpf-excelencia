package br.mp.mpf.simpletests.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PLANO_DE_TESTE")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_PLANO_DE_TESTE", allocationSize = 1)
public class PlanoDeTeste {

	@Id
	@Column(name = "ID_PLANO_DE_TESTE", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ID_PROJETO", nullable = false)
	private Projeto projeto;

	@Column(name = "NOME", nullable = false, length = 500)
	private String nome; // ex: RELEASE 01, SPRINT 02

	@Column(name = "DATA_INICIAL", nullable = false)
	private Date dataInicial;

	@Column(name = "DATA_FINAL", nullable = false)
	private Date dataFinal;

	@Column(name = "DESCRICAO", nullable = true, length = 4000)
	private String descricao;

	@Transient
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

	

	@Override
	public String toString() {
		return "PlanoDeTeste [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ (dataInicial != null ? "dataInicial=" + dataInicial + ", " : "")
				+ (dataFinal != null ? "dataFinal=" + dataFinal + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
				+ (projeto != null ? "projeto=" + projeto : "") + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanoDeTeste other = (PlanoDeTeste) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

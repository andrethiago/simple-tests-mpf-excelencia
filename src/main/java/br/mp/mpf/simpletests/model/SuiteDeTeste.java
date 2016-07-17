package br.mp.mpf.simpletests.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SUITE_DE_TESTE")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_SUITE_DE_TESTE", allocationSize = 1)
public class SuiteDeTeste {

    @Id
    @Column(name = "ID_SUITE_DE_TESTE", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CASO_DE_TESTE_SUITE_DE_TESTE", uniqueConstraints = {
	    @UniqueConstraint(columnNames = { "ID_SUITE_DE_TESTE", "ID_CASO_DE_TESTE" }) }, joinColumns = {
		    @JoinColumn(name = "ID_SUITE_DE_TESTE") }, inverseJoinColumns = {
			    @JoinColumn(name = "ID_CASO_DE_TESTE") })
    private List<CasoDeTeste> casos;

    @Column(name = "NOME", nullable = false, length = 500)
    private String nome;

    @Column(name = "DESCRICAO", nullable = true, length = 4000)
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PROJETO", nullable = false)
    private Projeto projeto;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public List<CasoDeTeste> getCasos() {
	return casos;
    }

    public void setCasos(List<CasoDeTeste> casos) {
	this.casos = casos;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Projeto getProjeto() {
	return projeto;
    }

    public void setProjeto(Projeto projeto) {
	this.projeto = projeto;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	SuiteDeTeste other = (SuiteDeTeste) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (nome == null) {
	    if (other.nome != null) {
		return false;
	    }
	} else if (!nome.equals(other.nome)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "SuiteDeTeste [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
		+ (descricao != null ? "descricao=" + descricao : "") + "]";
    }

}

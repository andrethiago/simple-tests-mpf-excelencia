package br.mp.mpf.simpletests.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROJETO")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_PROJETO", allocationSize = 1)
public class Projeto {

    @Id
    @Column(name = "ID_PROJETO", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 500)
    private String nome;

    @Column(name = "DESCRICAO", nullable = true, length = 4000)
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projeto")
    private List<Release> releases;

    public Projeto() {
    }

    public Projeto(String nome, String descricao) {
	this.nome = nome;
	this.descricao = descricao;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public List<Release> getReleases() {
	return releases;
    }

    public void setReleases(List<Release> releases) {
	this.releases = releases;
    }

    @Override
    public String toString() {
	return "Projeto [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
		+ (descricao != null ? "descricao=" + descricao : "") + "]";
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
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Projeto other = (Projeto) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	return true;
    }

}

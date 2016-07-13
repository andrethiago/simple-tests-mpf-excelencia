package br.mp.mpf.simpletests.model;

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

@Entity
@Table(name = "HISTORIA")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_HISTORIA", allocationSize = 1)
public class Historia {

    @Id
    @Column(name = "ID_HISTORIA", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 500)
    private String nome;

    @Column(name = "DESCRICAO", nullable = false, length = 5000)
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_RELEASE", nullable = false)
    private Release release;

    public Historia() {

    }

    public Historia(Release release, String nome, String descricao) {
	super();
	this.release = release;
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

    public Release getRelease() {
	return release;
    }

    public void setRelease(Release release) {
	this.release = release;
    }

    @Override
    public String toString() {
	return "Historia [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
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
	Historia other = (Historia) obj;
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

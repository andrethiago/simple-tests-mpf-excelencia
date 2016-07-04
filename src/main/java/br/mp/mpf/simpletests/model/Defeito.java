package br.mp.mpf.simpletests.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEFEITO")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_DEFEITO", allocationSize = 1)
public class Defeito {

    @Id
    @Column(name = "ID_DEFEITO", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 500)
    private String nome;

    @Column(name = "DESCRICAO", nullable = false, length = 4000)
    private String descricao;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ID_ITEM_EXECUCAO_TESTE", nullable = false)
    private ResultadoExecucaoTeste itemExecucao;

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

    public ResultadoExecucaoTeste getItemExecucao() {
	return itemExecucao;
    }

    public void setItemExecucao(ResultadoExecucaoTeste itemExecucao) {
	this.itemExecucao = itemExecucao;
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
	Defeito other = (Defeito) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Defeito [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
		+ (descricao != null ? "descricao=" + descricao + ", " : "")
		+ (itemExecucao != null ? "itemExecucao=" + itemExecucao : "") + "]";
    }

}

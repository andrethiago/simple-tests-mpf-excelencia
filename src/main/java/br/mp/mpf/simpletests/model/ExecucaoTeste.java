package br.mp.mpf.simpletests.model;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EXECUCAO_TESTE")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_EXECUCAO_TESTE", allocationSize = 1)
public class ExecucaoTeste {

    @Id
    @Column(name = "ID_EXECUCAO_TESTE", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 500)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_RELEASE", nullable = false)
    private Release release;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "SUITE_DE_TESTE_EXECUCAO", uniqueConstraints = {
	    @UniqueConstraint(columnNames = { "ID_SUITE_DE_TESTE", "ID_EXECUCAO_TESTE" }) }, joinColumns = {
		    @JoinColumn(name = "ID_EXECUCAO_TESTE") }, inverseJoinColumns = {
			    @JoinColumn(name = "ID_SUITE_DE_TESTE") })
    private List<SuiteDeTeste> suites;

    @OneToMany(mappedBy = "execucao", cascade = CascadeType.ALL)
    private List<ResultadoExecucaoTeste> resultadosExecucao;

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

    public Boolean getPassou() {
	boolean passou = true;
	for (ResultadoExecucaoTeste itemExecucao : resultadosExecucao) {
	    if (itemExecucao.falhou() || itemExecucao.naoExecutado()) {
		return false;
	    }
	}
	return passou;
    }

    public Release getRelease() {
	return release;
    }

    public void setRelease(Release release) {
	this.release = release;
    }

    public List<SuiteDeTeste> getSuites() {
	return suites;
    }

    public void setSuites(List<SuiteDeTeste> suites) {
	this.suites = suites;
    }

    public List<ResultadoExecucaoTeste> getResultadosExecucao() {
	return resultadosExecucao;
    }

    public void setResultadosExecucao(List<ResultadoExecucaoTeste> resultadosExecucao) {
	this.resultadosExecucao = resultadosExecucao;
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
	ExecucaoTeste other = (ExecucaoTeste) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	return true;
    }

    public void adicionar(SuiteDeTeste suite) {
	if (suites == null) {
	    suites = new ArrayList<>();
	}
	suites.add(suite);
    }

    public void adicionar(ResultadoExecucaoTeste resultado) {
	if (resultadosExecucao == null) {
	    resultadosExecucao = new ArrayList<>();
	}
	resultadosExecucao.add(resultado);
    }

    @Override
    public String toString() {
	return "ExecucaoTeste [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
		+ ("passou=" + getPassou() + ", ") + (release != null ? "release=" + release : "") + "]";
    }

}

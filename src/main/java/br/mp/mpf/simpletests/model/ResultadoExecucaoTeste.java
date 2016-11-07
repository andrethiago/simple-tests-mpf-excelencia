package br.mp.mpf.simpletests.model;

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

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import br.mp.mpf.simpletests.infra.model.GenericEnumUserType;

@Entity
@Table(name = "RESULTADO_EXECUCAO_TESTE")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_RESULTADO_EXECUCAO_TESTE", allocationSize = 1)
@TypeDefs(value = { @TypeDef(name = "StatusExecucao", typeClass = GenericEnumUserType.class, parameters = {
	@Parameter(name = "enumClass", value = "br.mp.mpf.simpletests.model.StatusExecucao") }) })
public class ResultadoExecucaoTeste {

    @Id
    @Column(name = "ID_RESULTADO_EXECUCAO_TESTE", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CASO_DE_TESTE", nullable = false)
    private CasoDeTeste casoDeTeste;

    @Column(name = "STATUS_EXECUCAO", nullable = false)
    @Type(type = "StatusExecucao")
    private StatusExecucao status = StatusExecucao.NAO_EXECUTADO;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DEFEITO", nullable = true)
    private Defeito defeito;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_EXECUCAO", nullable = false)
    private ExecucaoTeste execucao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TESTADOR", nullable = false)
    private Usuario testador;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public CasoDeTeste getCasoDeTeste() {
	return casoDeTeste;
    }

    public void setCasoDeTeste(CasoDeTeste casoDeTeste) {
	this.casoDeTeste = casoDeTeste;
    }

    public StatusExecucao getStatus() {
	return status;
    }

    public void setStatus(StatusExecucao status) {
	this.status = status;
    }

    public Defeito getDefeito() {
	return defeito;
    }

    public void setDefeito(Defeito defeito) {
	this.defeito = defeito;
    }

    public ExecucaoTeste getExecucao() {
	return execucao;
    }

    public void setExecucao(ExecucaoTeste execucao) {
	this.execucao = execucao;
    }

    public Usuario getTestador() {
	return testador;
    }

    public void setTestador(Usuario testador) {
	this.testador = testador;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((casoDeTeste == null) ? 0 : casoDeTeste.hashCode());
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
	ResultadoExecucaoTeste other = (ResultadoExecucaoTeste) obj;
	if (casoDeTeste == null) {
	    if (other.casoDeTeste != null) {
		return false;
	    }
	} else if (!casoDeTeste.equals(other.casoDeTeste)) {
	    return false;
	}
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
	return "ResultadoExecucaoTeste [" + (id != null ? "id=" + id + ", " : "")
		+ (casoDeTeste != null ? "casoDeTeste=" + casoDeTeste + ", " : "")
		+ (status != null ? "status=" + status + ", " : "") + (testador != null ? "testador=" + testador : "")
		+ "]";
    }

    public boolean passou() {
	return this.status.equals(StatusExecucao.PASSOU);
    }

    public boolean falhou() {
	return this.status.equals(StatusExecucao.FALHOU);
    }

    public boolean naoExecutado() {
	return this.status.equals(StatusExecucao.NAO_EXECUTADO);
    }

}

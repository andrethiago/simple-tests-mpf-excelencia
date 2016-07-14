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

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import br.mp.mpf.simpletests.infra.model.GenericEnumUserType;

@Entity
@Table(name = "CASO_DE_TESTE")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_CASO_DE_TESTE", allocationSize = 1)
@TypeDefs(value = { @TypeDef(name = "TipoTeste", typeClass = GenericEnumUserType.class, parameters = {
	@Parameter(name = "enumClass", value = "br.mp.mpf.simpletests.model.TipoTeste") }) })
public class CasoDeTeste {

    @Id
    @Column(name = "ID_CASO_DE_TESTE", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 500)
    private String nome;

    @Column(name = "DESCRICAO", nullable = true, length = 4000)
    private String descricao;

    @Column(name = "PRE_CONDICOES", nullable = false, length = 10000)
    private String preCondicoes;

    @Column(name = "PASSOS", nullable = false, length = 10000)
    private String passos;

    @Column(name = "RESULTADO_ESPERADO", nullable = false, length = 10000)
    private String resultadoEsperado;

    @Column(name = "TIPO_TESTE", nullable = false)
    @Type(type = "TipoTeste")
    private TipoTeste tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROJETO", nullable = false)
    private Projeto projeto;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "HISTORIAS_CASO_DE_TESTE", uniqueConstraints = {
	    @UniqueConstraint(columnNames = { "ID_CASO_DE_TESTE", "ID_HISTORIA" }) }, joinColumns = {
		    @JoinColumn(name = "ID_CASO_DE_TESTE") }, inverseJoinColumns = {
			    @JoinColumn(name = "ID_HISTORIA") })
    private List<Historia> historiasAssociadas;

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

    public TipoTeste getTipo() {
	return tipo;
    }

    public void setTipo(TipoTeste tipo) {
	this.tipo = tipo;
    }

    public String getPreCondicoes() {
	return preCondicoes;
    }

    public void setPreCondicoes(String preCondicoes) {
	this.preCondicoes = preCondicoes;
    }

    public String getPassos() {
	return passos;
    }

    public void setPassos(String passos) {
	this.passos = passos;
    }

    public String getResultadoEsperado() {
	return resultadoEsperado;
    }

    public void setResultadoEsperado(String resultadoEsperado) {
	this.resultadoEsperado = resultadoEsperado;
    }

    public Projeto getProjeto() {
	return projeto;
    }

    public void setProjeto(Projeto projeto) {
	this.projeto = projeto;
    }

    public List<Historia> getHistoriasAssociadas() {
	return historiasAssociadas;
    }

    public void setHistoriasAssociadas(List<Historia> historiasAssociadas) {
	this.historiasAssociadas = historiasAssociadas;
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
	CasoDeTeste other = (CasoDeTeste) obj;
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
	return "CasoDeTeste [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
		+ (tipo != null ? "tipo=" + tipo + ", " : "")
		+ (descricao != null ? "descricao=" + descricao + ", " : "")
		+ (preCondicoes != null ? "preCondicoes=" + preCondicoes + ", " : "")
		+ (passos != null ? "passos=" + passos + ", " : "")
		+ (resultadoEsperado != null ? "resultadoEsperado=" + resultadoEsperado : "") + "]";
    }

}

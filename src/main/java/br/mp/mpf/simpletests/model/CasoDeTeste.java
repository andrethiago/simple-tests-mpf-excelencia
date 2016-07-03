package br.mp.mpf.simpletests.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import br.mp.mpf.simpletests.infra.model.GenericEnumUserType;

@Entity
@Table(name = "CASO_DE_TESTE")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_CASO_DE_TESTE", allocationSize = 1)
@TypeDefs(value = { @TypeDef(name = "TipoTeste", typeClass = GenericEnumUserType.class, parameters = { @Parameter(name = "enumClass", value = "br.mp.mpf.simpletests.model.TipoTeste") }) })
public class CasoDeTeste {

	@Id
	@Column(name = "ID_CASO_DE_TESTE", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	private Long id;

	@Column(name = "NOME", nullable = false, length = 500)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TESTADOR", nullable = false)
	private Usuario testador;

	@Column(name = "TIPO_CONVITE", nullable = false)
	@Type(type = "TipoTeste")
	private TipoTeste tipo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "HISTORIA_CASO_DE_TESTE", 
		joinColumns = {@JoinColumn(name = "ID_CASO_DE_TESTE")}, inverseJoinColumns = {@JoinColumn(name = "ID_HISTORIA")})
	private Set<Historia> historias;
	
	// passos ???

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

	public Usuario getTestador() {
		return testador;
	}

	public void setTestador(Usuario testador) {
		this.testador = testador;
	}

	public TipoTeste getTipo() {
		return tipo;
	}

	public void setTipo(TipoTeste tipo) {
		this.tipo = tipo;
	}

	public Set<Historia> getHistorias() {
		return historias;
	}

	public void setHistorias(Set<Historia> historias) {
		this.historias = historias;
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
		CasoDeTeste other = (CasoDeTeste) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CasoDeTeste [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ (tipo != null ? "tipo=" + tipo : "") + "]";
	}


}

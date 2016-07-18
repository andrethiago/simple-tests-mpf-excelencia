package br.mp.mpf.simpletests.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "USUARIO")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_USUARIO", allocationSize = 1)
@DynamicUpdate
// @JsonIgnoreProperties(value = { "senha" })
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 500)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 500)
    private String email;

    @Column(name = "SENHA", nullable = false, length = 500)
    // @JsonIgnore
    private String senha;

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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    @JsonIgnore
    public String getSenha() {
	return senha;
    }

    @JsonProperty
    public void setSenha(String senha) {
	this.senha = senha;
    }

    @Override
    public String toString() {
	return "Usuario [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
		+ (email != null ? "email=" + email : "") + "]";
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
	Usuario other = (Usuario) obj;
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

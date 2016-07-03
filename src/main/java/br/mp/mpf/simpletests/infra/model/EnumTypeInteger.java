package br.mp.mpf.simpletests.infra.model;

/**
 * Esta interface deve ser implementada pelos enums que vão ser utilizados nos mapeamentos JPA/Hibernate.
 * 
 * @author André Thiago
 * 
 */
public interface EnumTypeInteger {
    public Integer getCodigo();

    public String getDescricao();
}

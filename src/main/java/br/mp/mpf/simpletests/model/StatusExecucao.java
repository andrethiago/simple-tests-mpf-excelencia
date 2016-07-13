package br.mp.mpf.simpletests.model;

import br.mp.mpf.simpletests.infra.model.EnumTypeInteger;

public enum StatusExecucao implements EnumTypeInteger {

    FALHOU(1, "Falhou"), PASSOU(2, "Passou"), NAO_EXECUTADO(3, "Não Executado");

    Integer codigo;

    String descricao;

    StatusExecucao(Integer codigo, String descricao) {
	this.codigo = codigo;
	this.descricao = descricao;
    }

    @Override
    public Integer getCodigo() {
	return codigo;
    }

    @Override
    public String getDescricao() {
	return descricao;
    }

}

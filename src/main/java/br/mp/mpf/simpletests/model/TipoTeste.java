package br.mp.mpf.simpletests.model;

import br.mp.mpf.simpletests.infra.model.EnumTypeInteger;

public enum TipoTeste implements EnumTypeInteger {

    FUNCIONAL(1, "Funcional"), USABILIDADE(2, "Usabilidade"), SEGURANCA(3, "Segurança"), DESEMPENHO(4,
	    "Desempenho"), REGRESSAO(5, "Regressão"), AUTOMATIZADO(6, "Automatizado"), OUTRO(7, "Outro");

    Integer codigo;

    String descricao;

    TipoTeste(Integer codigo, String descricao) {
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

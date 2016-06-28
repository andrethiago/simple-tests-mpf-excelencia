package br.mp.mpf.simpletests.model;

public enum TipoTeste {

	FUNCIONAL(1, "Funcionall"), USABILIDADE(2, "Usabilidade"), SEGURANCA(3, "Segurança"), DESEMPENHO(4, "Desempenho");

	Integer codigo;

	String descricao;

	TipoTeste(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}

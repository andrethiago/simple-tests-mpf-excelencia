package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.model.ResultadoExecucaoTeste;
import br.mp.mpf.simpletests.model.repository.ResultadoExecucaoTesteRepository;

public class ResultadoExecucaoService {

    private ResultadoExecucaoTesteRepository repository;

    public ResultadoExecucaoService(ResultadoExecucaoTesteRepository repository) {
	super();
	this.repository = repository;
    }

    public ResultadoExecucaoTeste incluir(ResultadoExecucaoTeste entidade) {
	return repository.incluir(entidade);
    }

    public ResultadoExecucaoTeste alterar(ResultadoExecucaoTeste entidade) {
	return repository.alterar(entidade);
    }

    public void excluir(ResultadoExecucaoTeste entidade) {
	repository.excluir(entidade);
    }

    public ResultadoExecucaoTeste consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<ResultadoExecucaoTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}
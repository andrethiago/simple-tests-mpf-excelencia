package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.ResultadoExecucaoTeste;
import br.mp.mpf.simpletests.model.repository.ResultadoExecucaoTesteRepository;

public class ResultadoExecucaoService extends BaseCRUDService<ResultadoExecucaoTeste> {

    private ResultadoExecucaoTesteRepository repository;

    public ResultadoExecucaoService(ResultadoExecucaoTesteRepository repository) {
	super();
	this.repository = repository;
    }

    public List<ResultadoExecucaoTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}

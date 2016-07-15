package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.ExecucaoTeste;
import br.mp.mpf.simpletests.model.repository.ExecucaoTesteRepository;

public class ExecucaoTesteService extends BaseCRUDService<ExecucaoTeste> {

    private ExecucaoTesteRepository repository;

    public ExecucaoTesteService(ExecucaoTesteRepository repository) {
	super();
	this.repository = repository;
    }

    public List<ExecucaoTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}

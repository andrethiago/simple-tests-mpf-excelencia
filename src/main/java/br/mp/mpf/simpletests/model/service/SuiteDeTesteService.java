package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.SuiteDeTeste;
import br.mp.mpf.simpletests.model.repository.SuiteDeTesteRepository;

public class SuiteDeTesteService extends BaseCRUDService<SuiteDeTeste> {

    private SuiteDeTesteRepository repository;

    public SuiteDeTesteService(SuiteDeTesteRepository repository) {
	super();
	this.repository = repository;
    }

    public List<SuiteDeTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}

package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.repository.CasoDeTesteRepository;

public class CasoDeTesteService extends BaseCRUDService<CasoDeTeste> {

    private CasoDeTesteRepository repository;

    public CasoDeTesteService(CasoDeTesteRepository repository) {
	super();
	this.repository = repository;
    }

    public List<CasoDeTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}

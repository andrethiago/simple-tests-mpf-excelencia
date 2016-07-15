package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.Release;
import br.mp.mpf.simpletests.model.repository.ReleaseRepository;

public class ReleaseService extends BaseCRUDService<Release> {

    private ReleaseRepository repository;

    public ReleaseService(ReleaseRepository repository) {
	super();
	this.repository = repository;
    }

    public List<Release> consultarTodos() {
	return repository.consultarTodos();
    }

}

package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.model.Release;
import br.mp.mpf.simpletests.model.repository.ReleaseRepository;

public class ReleaseService {

    private ReleaseRepository repository;

    public ReleaseService(ReleaseRepository repository) {
	super();
	this.repository = repository;
    }

    public Release incluir(Release entidade) {
	return repository.incluir(entidade);
    }

    public Release alterar(Release entidade) {
	return repository.alterar(entidade);
    }

    public void excluir(Release entidade) {
	repository.excluir(entidade);
    }

    public Release consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<Release> consultarTodos() {
	return repository.consultarTodos();
    }

}

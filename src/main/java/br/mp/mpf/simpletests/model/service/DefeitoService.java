package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.Defeito;
import br.mp.mpf.simpletests.model.repository.DefeitoRepository;

public class DefeitoService extends BaseCRUDService<Defeito> {

    private DefeitoRepository repository;

    public DefeitoService(DefeitoRepository repository) {
	super();
	this.repository = repository;
    }

    public List<Defeito> consultarTodos() {
	return repository.consultarTodos();
    }

}

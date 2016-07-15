package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.repository.ProjetoRepository;

public class ProjetoService extends BaseCRUDService<Projeto> {

    private ProjetoRepository repository;

    public List<Projeto> consultarTodos() {
	return repository.consultarTodos();
    }

}

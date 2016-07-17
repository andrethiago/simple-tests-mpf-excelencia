package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.repository.CasoDeTesteRepository;

public class CasoDeTesteService {

    private CasoDeTesteRepository repository;

    public CasoDeTesteService(CasoDeTesteRepository repository) {
	super();
	this.repository = repository;
    }

    public CasoDeTeste incluir(CasoDeTeste entidade) {
	return repository.incluir(entidade);
    }

    public CasoDeTeste alterar(CasoDeTeste entidade) {
	return repository.alterar(entidade);
    }

    public void excluir(CasoDeTeste entidade) {
	repository.excluir(entidade);
    }

    public CasoDeTeste consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<CasoDeTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}

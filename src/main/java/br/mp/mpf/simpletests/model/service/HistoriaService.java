package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.model.Historia;
import br.mp.mpf.simpletests.model.repository.HistoriaRepository;

public class HistoriaService {

    private HistoriaRepository repository;

    public HistoriaService(HistoriaRepository repository) {
	super();
	this.repository = repository;
    }

    public Historia incluir(Historia entidade) {
	return repository.incluir(entidade);
    }

    public Historia alterar(Historia entidade) {
	return repository.alterar(entidade);
    }

    public void excluir(Historia entidade) {
	repository.excluir(entidade);
    }

    public Historia consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<Historia> consultarTodos() {
	return repository.consultarTodos();
    }

}

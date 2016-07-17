package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.repository.ProjetoRepository;

public class ProjetoService {

    private ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository) {
	super();
	this.repository = repository;
    }

    public Projeto incluir(Projeto entidade) {
	return repository.incluir(entidade);
    }

    public Projeto alterar(Projeto entidade) {
	return repository.alterar(entidade);
    }

    public void excluir(Projeto entidade) {
	repository.excluir(entidade);
    }

    public Projeto consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<Projeto> consultarTodos() {
	return repository.consultarTodos();
    }

}

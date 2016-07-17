package br.mp.mpf.simpletests.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.repository.ProjetoRepository;

@Service
public class ProjetoService {

    private ProjetoRepository repository;

    @Autowired
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

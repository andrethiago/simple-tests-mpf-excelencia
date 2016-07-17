package br.mp.mpf.simpletests.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpf.simpletests.model.SuiteDeTeste;
import br.mp.mpf.simpletests.model.repository.SuiteDeTesteRepository;

@Service
public class SuiteDeTesteService {

    private SuiteDeTesteRepository repository;

    @Autowired
    public SuiteDeTesteService(SuiteDeTesteRepository repository) {
	super();
	this.repository = repository;
    }

    public SuiteDeTeste incluir(SuiteDeTeste entidade) {
	return repository.incluir(entidade);
    }

    public SuiteDeTeste alterar(SuiteDeTeste entidade) {
	return repository.alterar(entidade);
    }

    public void excluir(SuiteDeTeste entidade) {
	repository.excluir(entidade);
    }

    public SuiteDeTeste consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<SuiteDeTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}

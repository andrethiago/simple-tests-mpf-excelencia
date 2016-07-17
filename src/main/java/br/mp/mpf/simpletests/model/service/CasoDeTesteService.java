package br.mp.mpf.simpletests.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.repository.CasoDeTesteRepository;

@Service
public class CasoDeTesteService {

    private CasoDeTesteRepository repository;

    @Autowired
    public CasoDeTesteService(CasoDeTesteRepository repository) {
	super();
	this.repository = repository;
    }

    @Transactional
    public CasoDeTeste incluir(CasoDeTeste entidade) {
	return repository.incluir(entidade);
    }

    @Transactional
    public CasoDeTeste alterar(CasoDeTeste entidade) {
	return repository.alterar(entidade);
    }

    @Transactional
    public void excluir(CasoDeTeste entidade) {
	repository.excluir(entidade);
    }

    public CasoDeTeste consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<CasoDeTeste> consultarTodos() {
	return repository.consultarTodos();
    }

    public List<CasoDeTeste> consultarPorProjeto(Projeto projeto) {
	return repository.consultarPorProjeto(projeto);
    }

}

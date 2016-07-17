package br.mp.mpf.simpletests.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mp.mpf.simpletests.model.Defeito;
import br.mp.mpf.simpletests.model.repository.DefeitoRepository;

@Service
public class DefeitoService {

    private DefeitoRepository repository;

    @Autowired
    public DefeitoService(DefeitoRepository repository) {
	super();
	this.repository = repository;
    }

    @Transactional
    public Defeito incluir(Defeito entidade) {
	return repository.incluir(entidade);
    }

    @Transactional
    public Defeito alterar(Defeito entidade) {
	return repository.alterar(entidade);
    }

    @Transactional
    public void excluir(Defeito entidade) {
	repository.excluir(entidade);
    }

    public Defeito consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<Defeito> consultarTodos() {
	return repository.consultarTodos();
    }

}

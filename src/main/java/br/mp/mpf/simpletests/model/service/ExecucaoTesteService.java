package br.mp.mpf.simpletests.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mp.mpf.simpletests.model.ExecucaoTeste;
import br.mp.mpf.simpletests.model.repository.ExecucaoTesteRepository;

@Service
public class ExecucaoTesteService {

    private ExecucaoTesteRepository repository;

    @Autowired
    public ExecucaoTesteService(ExecucaoTesteRepository repository) {
	super();
	this.repository = repository;
    }

    @Transactional
    public ExecucaoTeste incluir(ExecucaoTeste entidade) {
	return repository.incluir(entidade);
    }

    @Transactional
    public ExecucaoTeste alterar(ExecucaoTeste entidade) {
	return repository.alterar(entidade);
    }

    @Transactional
    public void excluir(ExecucaoTeste entidade) {
	repository.excluir(entidade);
    }

    public ExecucaoTeste consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<ExecucaoTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}

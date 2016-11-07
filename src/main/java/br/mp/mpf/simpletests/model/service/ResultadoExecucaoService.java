package br.mp.mpf.simpletests.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mp.mpf.simpletests.model.ResultadoExecucaoTeste;
import br.mp.mpf.simpletests.model.repository.ResultadoExecucaoTesteRepository;

@Service
public class ResultadoExecucaoService {

    private ResultadoExecucaoTesteRepository repository;

    @Autowired
    public ResultadoExecucaoService(ResultadoExecucaoTesteRepository repository) {
	super();
	this.repository = repository;
    }

    @Transactional
    public ResultadoExecucaoTeste incluir(ResultadoExecucaoTeste entidade) {
	return repository.incluir(entidade);
    }

    @Transactional
    public ResultadoExecucaoTeste alterar(ResultadoExecucaoTeste entidade) {
	return repository.alterar(entidade);
    }

    @Transactional
    public void excluir(ResultadoExecucaoTeste entidade) {
	repository.excluir(entidade);
    }

    public ResultadoExecucaoTeste consultarPorId(Long id) {
	return repository.consultarPorId(id);
    }

    public List<ResultadoExecucaoTeste> consultarTodos() {
	return repository.consultarTodos();
    }

}

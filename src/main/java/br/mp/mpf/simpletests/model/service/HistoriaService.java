package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.Historia;
import br.mp.mpf.simpletests.model.repository.HistoriaRepository;

public class HistoriaService extends BaseCRUDService<Historia> {

    private HistoriaRepository repository;

    public List<Historia> consultarTodos() {
	return repository.consultarTodos();
    }

}

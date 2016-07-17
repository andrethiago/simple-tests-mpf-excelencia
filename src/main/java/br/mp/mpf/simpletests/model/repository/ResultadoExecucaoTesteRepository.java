package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.ResultadoExecucaoTeste;

public class ResultadoExecucaoTesteRepository extends BaseCRUDRepository<ResultadoExecucaoTeste> {

    public ResultadoExecucaoTesteRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<ResultadoExecucaoTeste> consultarTodos() {
	Query query = session.createQuery("from ResultadoExecucaoTeste");
	return query.list();
    }

}

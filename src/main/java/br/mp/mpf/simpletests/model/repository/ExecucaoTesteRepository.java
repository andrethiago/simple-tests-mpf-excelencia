package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.model.ExecucaoTeste;

public class ExecucaoTesteRepository {

    Session session;

    public ExecucaoTesteRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<ExecucaoTeste> consultarTodos() {
	Query query = session.createQuery("from ExecucaoTeste");
	return query.list();
    }

}

package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.model.SuiteDeTeste;

public class SuiteDeTesteRepository {

    Session session;

    public SuiteDeTesteRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<SuiteDeTeste> consultarTodos() {
	Query query = session.createQuery("from SuiteDeTeste");
	return query.list();
    }

}

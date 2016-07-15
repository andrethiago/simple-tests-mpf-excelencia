package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.model.Defeito;

public class DefeitoRepository {

    Session session;

    public DefeitoRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<Defeito> consultarTodos() {
	Query query = session.createQuery("from Defeito");
	return query.list();
    }

}

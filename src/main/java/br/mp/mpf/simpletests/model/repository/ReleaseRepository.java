package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.model.Release;

public class ReleaseRepository {

    Session session;

    public ReleaseRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<Release> consultarTodos() {
	Query query = session.createQuery("from Release");
	return query.list();
    }

}

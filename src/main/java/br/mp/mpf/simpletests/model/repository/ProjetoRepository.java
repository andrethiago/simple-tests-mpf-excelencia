package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.model.Projeto;

public class ProjetoRepository {

    Session session;

    public ProjetoRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<Projeto> consultarTodos() {
	Query query = session.createQuery("from Projeto");
	return query.list();
    }

}

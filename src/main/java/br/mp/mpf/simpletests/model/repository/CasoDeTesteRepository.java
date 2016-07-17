package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.CasoDeTeste;

public class CasoDeTesteRepository extends BaseCRUDRepository<CasoDeTeste> {

    public CasoDeTesteRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<CasoDeTeste> consultarTodos() {
	Query query = session.createQuery("from CasoDeTeste");
	return query.list();
    }

}

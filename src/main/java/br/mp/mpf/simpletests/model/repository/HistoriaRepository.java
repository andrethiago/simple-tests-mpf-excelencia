package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.Historia;

public class HistoriaRepository extends BaseCRUDRepository<Historia> {

    public HistoriaRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<Historia> consultarTodos() {
	Query query = session.createQuery("from Historia");
	return query.list();
    }

}

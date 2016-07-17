package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.CasoDeTeste;

@Repository
public class CasoDeTesteRepository extends BaseCRUDRepository<CasoDeTeste> {

    //
    // public CasoDeTesteRepository(Session session) {
    // super();
    // this.session = session;
    // }

    @SuppressWarnings("unchecked")
    public List<CasoDeTeste> consultarTodos() {
	Query query = getSession().createQuery("from CasoDeTeste");
	return query.list();
    }

}

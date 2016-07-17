package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.Defeito;

@Repository
public class DefeitoRepository extends BaseCRUDRepository<Defeito> {

    // public DefeitoRepository(Session session) {
    // super();
    // this.session = session;
    // }

    @SuppressWarnings("unchecked")
    public List<Defeito> consultarTodos() {
	Query query = getSession().createQuery("from Defeito");
	return query.list();
    }

}

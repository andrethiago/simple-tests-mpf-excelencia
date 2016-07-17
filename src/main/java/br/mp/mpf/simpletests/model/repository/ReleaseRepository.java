package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.Release;

@Repository
public class ReleaseRepository extends BaseCRUDRepository<Release> {

    @SuppressWarnings("unchecked")
    public List<Release> consultarTodos() {
	Query query = getSession().createQuery("from Release");
	return query.list();
    }

}

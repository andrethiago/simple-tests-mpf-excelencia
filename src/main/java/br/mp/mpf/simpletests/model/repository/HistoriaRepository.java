package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.Historia;

@Repository
public class HistoriaRepository extends BaseCRUDRepository<Historia> {

    @SuppressWarnings("unchecked")
    public List<Historia> consultarTodos() {
	Query query = getSession().createQuery("from Historia");
	return query.list();
    }

}

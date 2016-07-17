package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.ExecucaoTeste;

@Repository
public class ExecucaoTesteRepository extends BaseCRUDRepository<ExecucaoTeste> {

    @SuppressWarnings("unchecked")
    public List<ExecucaoTeste> consultarTodos() {
	Query query = getSession().createQuery("from ExecucaoTeste");
	return query.list();
    }

}

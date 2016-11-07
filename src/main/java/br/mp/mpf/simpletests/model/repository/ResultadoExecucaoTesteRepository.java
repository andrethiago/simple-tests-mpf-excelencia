package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.ResultadoExecucaoTeste;

@Repository
public class ResultadoExecucaoTesteRepository extends BaseCRUDRepository<ResultadoExecucaoTeste> {

    @SuppressWarnings("unchecked")
    public List<ResultadoExecucaoTeste> consultarTodos() {
	Query query = getSession().createQuery("from ResultadoExecucaoTeste");
	return query.list();
    }

}

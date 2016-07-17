package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.SuiteDeTeste;

@Repository
public class SuiteDeTesteRepository extends BaseCRUDRepository<SuiteDeTeste> {

    @SuppressWarnings("unchecked")
    public List<SuiteDeTeste> consultarTodos() {
	Query query = getSession().createQuery("from SuiteDeTeste");
	return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<SuiteDeTeste> consultarPorProjeto(Projeto projeto) {
	Query query = getSession().createQuery("from SuiteDeTeste r join fetch r.projeto where r.projeto = :projeto");
	query.setParameter("projeto", projeto);
	return query.list();
    }

}

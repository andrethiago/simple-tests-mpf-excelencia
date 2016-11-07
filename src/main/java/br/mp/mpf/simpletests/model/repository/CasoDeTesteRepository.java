package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.Projeto;

@Repository
public class CasoDeTesteRepository extends BaseCRUDRepository<CasoDeTeste> {

    @SuppressWarnings("unchecked")
    public List<CasoDeTeste> consultarTodos() {
	Query query = getSession().createQuery("from CasoDeTeste");
	return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<CasoDeTeste> consultarPorProjeto(Projeto projeto) {
	Query query = getSession().createQuery("from CasoDeTeste r join fetch r.projeto where r.projeto = :projeto");
	query.setParameter("projeto", projeto);
	return query.list();
    }

}

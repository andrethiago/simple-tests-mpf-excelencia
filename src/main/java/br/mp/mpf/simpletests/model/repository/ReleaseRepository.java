package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.Release;

@Repository
public class ReleaseRepository extends BaseCRUDRepository<Release> {

    @SuppressWarnings("unchecked")
    public List<Release> consultarTodos() {
	Query query = getSession().createQuery("from Release");
	return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Release> consultarPorProjeto(Projeto projeto) {
	Query query = getSession().createQuery("from Release r join fetch r.projeto where r.projeto = :projeto");
	query.setParameter("projeto", projeto);
	return query.list();
    }

}

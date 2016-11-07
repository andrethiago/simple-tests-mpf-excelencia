package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.Projeto;

@Repository
public class ProjetoRepository extends BaseCRUDRepository<Projeto> {

    @SuppressWarnings("unchecked")
    public List<Projeto> consultarTodos() {
	Query query = getSession().createQuery("from Projeto");
	return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Projeto> consultarPorNome(String nome) {
	Query query = getSession().createQuery("from Projeto where lower(nome) like '%' || lower(:nome) || '%' ");
	query.setParameter("nome", nome);
	return query.list();
    }

}

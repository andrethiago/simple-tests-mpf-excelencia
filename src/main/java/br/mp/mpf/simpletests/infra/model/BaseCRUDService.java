package br.mp.mpf.simpletests.infra.model;

import org.hibernate.Session;

public class BaseCRUDService<E extends Object> {

    Session session;

    public E incluir(E entidade) {
	session.save(entidade);
	return entidade;
    }

    public E alterar(E entidade) {
	session.update(entidade);
	return entidade;
    }

    public void excluir(E entidade) {
	session.delete(entidade);
    }

    @SuppressWarnings("unchecked")
    public E consultarPorId(Class<E> clazz, Long id) {
	return (E) session.get(clazz, id);
    }

}

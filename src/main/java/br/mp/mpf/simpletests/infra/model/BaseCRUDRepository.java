package br.mp.mpf.simpletests.infra.model;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;

public class BaseCRUDRepository<E> {

    protected Session session;

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
    public E consultarPorId(Long id) {
	return (E) session.get(getClazz(), id);
    }

    @SuppressWarnings("unchecked")
    private Class<E> getClazz() {
	return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}

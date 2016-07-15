package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.mp.mpf.simpletests.model.Usuario;

public class UsuarioRepository {

    Session session;

    public UsuarioRepository(Session session) {
	super();
	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> consultarTodos() {
	Query query = session.createQuery("from Usuario");
	return query.list();
    }

    public Usuario consultarPorEmail(String email) {
	Query query = session.createQuery("from Usuario where email = :email");
	query.setParameter("email", email);
	return (Usuario) query.uniqueResult();
    }

}

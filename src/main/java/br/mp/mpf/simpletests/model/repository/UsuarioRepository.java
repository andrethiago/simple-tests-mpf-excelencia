package br.mp.mpf.simpletests.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.mp.mpf.simpletests.infra.model.BaseCRUDRepository;
import br.mp.mpf.simpletests.model.Usuario;

@Repository
public class UsuarioRepository extends BaseCRUDRepository<Usuario> {

    // public UsuarioRepository(Session session) {
    // super();
    // this.session = session;
    // }

    @SuppressWarnings("unchecked")
    public List<Usuario> consultarTodos() {
	Query query = getSession().createQuery("from Usuario");
	return query.list();
    }

    public Usuario consultarPorEmail(String email) {
	Query query = getSession().createQuery("from Usuario where email = :email");
	query.setParameter("email", email);
	return (Usuario) query.uniqueResult();
    }

}

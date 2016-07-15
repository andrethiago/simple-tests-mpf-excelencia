package br.mp.mpf.simpletests.testes;

import java.util.List;

import org.hibernate.Session;

import br.mp.mpf.simpletests.model.Usuario;
import br.mp.mpf.simpletests.model.repository.UsuarioRepository;
import br.mp.mpf.simpletests.model.service.UsuarioService;
import br.mp.mpf.simpletests.util.HibernateUtil;

public class ExemplosUsoServicosRepositoriosSemSpring {

    public static void main(String[] args) {
	ExemplosUsoServicosRepositoriosSemSpring eusr = new ExemplosUsoServicosRepositoriosSemSpring();
	eusr.listarUsuarios();
    }

    private void listarUsuarios() {
	Session session = HibernateUtil.getSession();
	UsuarioRepository repository = new UsuarioRepository(session);
	UsuarioService service = new UsuarioService(repository);

	List<Usuario> usuarios = service.consultarTodos();

	for (Usuario usuario : usuarios) {
	    System.out.println(usuario);
	}

	System.out.println(service.consultarPorId(Usuario.class, 1L));
    }

}

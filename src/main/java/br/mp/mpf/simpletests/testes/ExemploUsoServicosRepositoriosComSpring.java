package br.mp.mpf.simpletests.testes;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.mp.mpf.simpletests.infra.spring.MainConfig;
import br.mp.mpf.simpletests.model.Usuario;
import br.mp.mpf.simpletests.model.service.UsuarioService;

public class ExemploUsoServicosRepositoriosComSpring {

    public static void main(String[] args) {

	ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

	UsuarioService usuarioService = ctx.getBean(UsuarioService.class);
	List<Usuario> usuarios = usuarioService.consultarTodos();

	for (Usuario usuario : usuarios) {
	    System.out.println(usuario);
	}

	System.exit(0);

    }

}

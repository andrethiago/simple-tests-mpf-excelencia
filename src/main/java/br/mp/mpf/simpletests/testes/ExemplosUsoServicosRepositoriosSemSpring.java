package br.mp.mpf.simpletests.testes;

public class ExemplosUsoServicosRepositoriosSemSpring {

    public static void main(String[] args) {
	ExemplosUsoServicosRepositoriosSemSpring eusr = new ExemplosUsoServicosRepositoriosSemSpring();
	eusr.listarUsuarios();

	System.exit(0);
    }

    private void listarUsuarios() {
	// Toda vez que quero fazer uma operação, tenho que instanciar um
	// repositorio - dando uma session
	// pra ele, instanciar o serviço e passar o repositorio pra ele. Mas eu
	// só quero o serviço :-(

	// Session session = HibernateUtil.getSession();
	// UsuarioRepository repository = new UsuarioRepository(session);
	// UsuarioService service = new UsuarioService(repository);
	//
	// List<Usuario> usuarios = service.consultarTodos();
	//
	// for (Usuario usuario : usuarios) {
	// System.out.println(usuario);
	// }
	//
	// System.out.println(service.consultarPorId(1L));
	//
	// ProjetoRepository projetoRepository = new ProjetoRepository(session);
	// ProjetoService projetoService = new
	// ProjetoService(projetoRepository);
	//
	// System.out.println(projetoService.consultarPorId(2L));
	//
	// session.close();
    }

}

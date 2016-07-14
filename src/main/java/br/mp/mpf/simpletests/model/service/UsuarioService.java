package br.mp.mpf.simpletests.model.service;

import java.util.List;

import br.mp.mpf.simpletests.infra.model.BaseCRUDService;
import br.mp.mpf.simpletests.model.Usuario;
import br.mp.mpf.simpletests.model.repository.UsuarioRepository;

public class UsuarioService extends BaseCRUDService<Usuario> {

    private UsuarioRepository repository;

    public List<Usuario> consultarTodos() {
	return repository.consultarTodos();
    }

}

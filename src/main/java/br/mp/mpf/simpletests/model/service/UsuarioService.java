package br.mp.mpf.simpletests.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mp.mpf.simpletests.infra.exception.EntidadeNaoEncontradaException;
import br.mp.mpf.simpletests.model.Usuario;
import br.mp.mpf.simpletests.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
	super();
	this.repository = repository;
    }

    @Transactional
    public Usuario incluir(Usuario usuario) {
	repository.incluir(usuario);
	return usuario;
    }

    @Transactional
    public Usuario alterar(Usuario usuario) {
	repository.alterar(usuario);
	return usuario;
    }

    @Transactional
    public void excluir(Usuario usuario) {
	repository.excluir(usuario);
    }

    public Usuario consultarPorId(Long id) {
	Usuario usuario = repository.consultarPorId(id);
	if (usuario != null) {
	    return usuario;
	}
	throw new EntidadeNaoEncontradaException("Usuário não encontrado");
    }

    public List<Usuario> consultarTodos() {
	return repository.consultarTodos();
    }

    public Usuario consultarPorEmail(String email) {
	return repository.consultarPorEmail(email);
    }

}

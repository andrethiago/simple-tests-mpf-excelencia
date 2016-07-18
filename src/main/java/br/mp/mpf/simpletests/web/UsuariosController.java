package br.mp.mpf.simpletests.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mp.mpf.simpletests.model.Usuario;
import br.mp.mpf.simpletests.model.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Usuario> usuarios() {
	return usuarioService.consultarTodos();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Usuario porId(@PathVariable Long id) {
	// TODO tratar o id inexistente
	return usuarioService.consultarPorId(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> incluir(@RequestBody Usuario usuario) {
	Map<String, Object> resultado = new HashMap<>();
	try {
	    usuario = usuarioService.incluir(usuario);
	    resultado.put("success", true);
	    resultado.put("mensagem", "Usuário incluído com sucesso");
	} catch (Exception e) {
	    e.printStackTrace();
	    resultado.put("success", false);
	    resultado.put("mensagem", e.getMessage());
	}
	return resultado;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> excluir(@PathVariable Long id) {
	Map<String, Object> resultado = new HashMap<>();
	try {
	    Usuario usuario = new Usuario();
	    usuario.setId(id);
	    usuarioService.excluir(usuario);
	    resultado.put("success", true);
	    resultado.put("mensagem", "Usuário removido com sucesso.");
	} catch (Exception e) {
	    e.printStackTrace();
	    resultado.put("success", false);
	    resultado.put("mensagem", e.getMessage());
	}
	return resultado;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> alterar(@RequestBody Usuario usuario) {
	Map<String, Object> resultado = new HashMap<>();
	try {
	    usuario = usuarioService.alterar(usuario);
	    resultado.put("success", true);
	    resultado.put("mensagem", "Usuário alterado com sucesso");
	} catch (Exception e) {
	    e.printStackTrace();
	    resultado.put("success", false);
	    resultado.put("mensagem", e.getMessage());
	}
	return resultado;
    }

}
